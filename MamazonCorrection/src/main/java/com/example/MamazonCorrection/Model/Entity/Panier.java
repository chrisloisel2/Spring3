package com.example.MamazonCorrection.Model.Entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Panier {
	
	
	public Panier(Long id, User user, Set<Item> item)
	{
		this.id = id;
		this.user = user;
		this.item = item;
	}
	public Panier()
	{
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@OneToOne(mappedBy = "panier")
	private User user;
	
	
	@ManyToMany
	@JoinTable(name = "panier_item",
	joinColumns = @JoinColumn(name="panier_id"),
	inverseJoinColumns = @JoinColumn(name="items_id")
	)
	private Set<Item> item = new LinkedHashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Item> getItem() {
		return item;
	}


	public void setItem(Set<Item> item) {
		this.item = item;
	}

}
