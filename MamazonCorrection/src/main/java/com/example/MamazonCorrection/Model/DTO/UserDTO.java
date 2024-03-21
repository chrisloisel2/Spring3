package com.example.MamazonCorrection.Model.DTO;

import com.example.MamazonCorrection.Model.Entity.Panier;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class UserDTO {
	
	public UserDTO()
	{
		
	}
	
	public UserDTO(Long id, String name, String email, String password, int age, Long panier) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.panier = panier;
	}
	
	private Long id;
	private String name;
	private String email;
	// le password peut etre supprimer si il est aussi supp dans le front pour des questions de sécurité
	private String password;
	private int age;
	// Transformation du panier en Id Car le panier va faire des boucles infini de dépendances
	private Long panier;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPanier() {
		return panier;
	}
	public void setPanier(Long panier) {
		this.panier = panier;
	}
}
