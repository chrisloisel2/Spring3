package com.example.ExempleAPIBDD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ExempleAPIBDD.Model.Entity.UserEntity;
import com.example.ExempleAPIBDD.Model.Repository.UserRepository;

@Service
public class UserService<T, Trepo> {
	// Crud
	
	public Trepo repo;
	
	public UserService(Trepo dependance)
	{
		this.repo = dependance;
	}

	public Iterable<T> getAll()
	{
		return this.repo.findAll();
	}
	
	public Optional<T> getById(Long id)
	{
		return this.repo.findById(id);
	}
	
	public UserEntity UpdateById(Long id, T data)
	{
		UserEntity user = this.repo.findById(id).get();
		
		user.setCredit(data.getCredit());
		user.setName(data.getName());
		user.setEmail(data.getEmail());
		
		return this.repo.save(user);
	}
	
	public UserEntity AddUser(T data)
	{
		return this.repo.save(data);
	}
	
	public void DeleteById(Long id)
	{
		this.repo.deleteById(id);
	}
}
