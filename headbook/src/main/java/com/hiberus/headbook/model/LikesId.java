package com.hiberus.headbook.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Embeddable;


@Embeddable
public class LikesId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6974149841273019759L;
	
	private UUID usuario;
	private UUID post;
	
	
	public UUID getUsuario() {
		return usuario;
	}
	public void setUsuario(UUID usuario) {
		this.usuario = usuario;
	}
	public UUID getPost() {
		return post;
	}
	public void setPost(UUID post) {
		this.post = post;
	}
	
	public LikesId() { 
	}
	
	public LikesId(UUID usuario, UUID post){
        this.usuario= usuario;
        this.post = post;
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikesId)) return false;
        LikesId that = (LikesId) o;
        return Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getPost(), that.getPost());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getPost());
    }
}