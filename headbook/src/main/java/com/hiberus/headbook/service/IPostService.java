package com.hiberus.headbook.service;

import java.util.List;
import java.util.UUID;

import com.hiberus.headbook.dto.PostDTO;
import com.hiberus.headbook.model.Post;

public interface IPostService {
	public List<Post> findAllByOrderByDateDesc();
	Post getPostById(UUID id);
	Post setLikesPost(UUID id);
	String addPost(PostDTO postDTO);
}
