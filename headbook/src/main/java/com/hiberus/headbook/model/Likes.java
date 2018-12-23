package com.hiberus.headbook.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Likes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2033292578709400901L;
	
	
	

	
	private LikesId likesid;
	private Usuario usuario;
	private Post post;
	
	@EmbeddedId
	public LikesId getLikesid() {
		return likesid;
	}
	
	public void setLikesid(LikesId likesid) {
		this.likesid = likesid;
	}
	
	public Likes() {
	}
	
	
	public Likes(LikesId likesid, Usuario usuario, Post post) {
		super();
		this.likesid = likesid;
		this.usuario = usuario;
		this.post = post;
	}
	
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "likes", cascade = CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	@ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name="post",  updatable=false, insertable=false)
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
