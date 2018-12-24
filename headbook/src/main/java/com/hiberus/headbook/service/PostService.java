package com.hiberus.headbook.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hiberus.headbook.dto.PostDTO;
import com.hiberus.headbook.model.Likes;
import com.hiberus.headbook.model.Post;
import com.hiberus.headbook.model.Usuario;
import com.hiberus.headbook.repository.PostRepository;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
    private ILikesService likesService;
	@Autowired
    private IUsuarioService usuarioService;
	
	@Override
	public Post getPostById(UUID id) {
		// TODO Auto-generated method stub
		Post obj = postRepository.findById(id).get();
		return obj;
	}

	@Override
	@Transactional
	public String addPost(PostDTO postDTO,String user) {
		// TODO Auto-generated method stub
		try {
			Usuario usuario=usuarioService.getUsuarioByUsername(user);
			Date date=null;
			
			if (usuario==null) return "El usuario no existe" ;
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
			String dateInString = postDTO.getFecha();
			date = formatter.parse(dateInString);
			
			Post post=new Post();
			post.setUsuario(usuario);
			post.setContent(postDTO.getContenido());
			post.setDate(date);
			if (postDTO.getTitulo().length()>255)
				post.setTitle(postDTO.getTitulo().substring(0, 254));
			else post.setTitle(postDTO.getTitulo());
			Set<Post> posts=usuario.getPosts();
			posts.add(post);
			usuario.setPosts(posts);
		} catch ( Exception  e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return e.getMessage();
		}
		return null;
	}

	@Override
	public List<Post> findAllByOrderByDateDesc() {
		// TODO Auto-generated method stub
		List<Post> obj = postRepository.findAllByOrderByDateDesc();
		return obj;
	}
	
	@Override
	@Transactional
	public Post setLikesPost(UUID id,String user) {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioService.getUsuarioByUsername(user);
		Post post = postRepository.findById(id).get();
		if (!(likesService.existsLikes(post, usuario ))) {
			Likes likes=likesService.addLikes(post,usuario);
			Set<Likes> likesSet=post.getLikes();
			likesSet.add(likes);
			post.setLikes(likesSet);
		}
		return post;
	}

}
