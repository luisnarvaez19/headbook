package com.hiberus.headbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.headbook.model.Likes;
import com.hiberus.headbook.model.LikesId;

@Repository
public interface LikesRepository extends JpaRepository<Likes, LikesId>{

}
