package com.hiberus.headbook.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hiberus.headbook.dto.PostDTO;
import com.hiberus.headbook.model.Post;
import com.hiberus.headbook.service.IPostService;

@Controller
public class PostController {
	
	@Autowired
    private IPostService postService;
	
	
	
    @RequestMapping("/home")
    public String listaPosts(Model model, HttpServletRequest request) {
    	
    	List<Post> listaPost=postService.findAllByOrderByDateDesc();
        model.addAttribute("posts", listaPost);
        return "index";
    }
   
    @GetMapping("/agregar")
    public String showForm(Model model) {
        model.addAttribute("postDTO", new PostDTO());
        return "agrega_post";
    }
    
    @GetMapping("/detalle/{id}")
    public String showDetalleForm(@PathVariable("id") UUID id, Model model) {
        Post post = postService.getPostById(id);
        
        model.addAttribute("post", post);
        return "detalle_post";
    }
    
    @GetMapping("/likes/{id}")
    public String setLikesPost(@PathVariable("id") UUID id, Model model,HttpServletRequest request) {
        Post post = postService.getPostById(id);
        String user = request.getRemoteUser();
        postService.setLikesPost(id,user);
        model.addAttribute("post", post);
        return "redirect:/home";
    }
    
    @PostMapping("/agregapost")
    public String agregaPost(PostDTO postDTO,  Model model,HttpServletRequest request) {
    	String user = request.getRemoteUser();
        String mensaje=postService.addPost(postDTO,user);
    	if (mensaje==null)
        	return "redirect:/home";
        else {
        	if (mensaje.equals("No value present"))
        		model.addAttribute("mensaje","El usuario no existe");
        	else
        		model.addAttribute("mensaje",mensaje);
        	return "agrega_post";
        }
        	
    }
    
   
    
    
}
