package com.example.MamazonCorrection.Model.DTO;

import java.util.Set;

import com.example.MamazonCorrection.Model.Entity.Item;

public class PanierDTO {
	public PanierDTO(Long id, Long userId, Set<Item> liste)
	{
		this.id = id;
		this.liste = liste;
		this.userId = userId;
	}
	
	public PanierDTO()
	{
	}
	
	private Long id;
	private Long userId;
	private Set<Item> liste;

	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Item> getListe() {
		return liste;
	}
	public void setListe(Set<Item> liste) {
		this.liste = liste;
	}
}
