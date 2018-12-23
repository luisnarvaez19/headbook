package com.hiberus.headbook.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.headbook.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, UUID>{
	public List<Post> findAllByOrderByDateDesc();
}
