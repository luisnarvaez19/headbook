package com.hiberus.headbook.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.headbook.model.Likes;
import com.hiberus.headbook.model.LikesId;
import com.hiberus.headbook.model.Post;
import com.hiberus.headbook.model.Usuario;
import com.hiberus.headbook.repository.LikesRepository;

@Service
public class LikesService implements ILikesService {

	@Autowired
	private LikesRepository likesRepository;
	
	@Override
	public Likes addLikes(Post post, Usuario usuario) {
		// TODO Auto-generated method stub
		LikesId likesid=new LikesId(usuario.getId(),post.getId());
		Likes likes=new Likes(likesid, usuario, post);
		return likes;
	}
	
	@Override
	public boolean existsLikes(Post post, Usuario usuario) {
		LikesId likesid=new LikesId(usuario.getId(),post.getId());
		return likesRepository.existsById(likesid);
	}
}
