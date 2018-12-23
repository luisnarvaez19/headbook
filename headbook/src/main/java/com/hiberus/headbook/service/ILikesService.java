package com.hiberus.headbook.service;

import com.hiberus.headbook.model.Likes;
import com.hiberus.headbook.model.Post;
import com.hiberus.headbook.model.Usuario;


public interface ILikesService {
	Likes addLikes(Post post, Usuario usuario);
	boolean existsLikes(Post post, Usuario usuario);
}
