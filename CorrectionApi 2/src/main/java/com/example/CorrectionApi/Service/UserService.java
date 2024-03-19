package com.example.CorrectionApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.CorrectionApi.Model.Entity.User;
import com.example.CorrectionApi.Model.Repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repo;
	
	public UserService(UserRepository repo)
	{
		this.repo = repo;
	}
	
	public User CreateUser(User data) {
		return this.repo.save(data);
		
	}

	public User UpdateUser(User data, Long id) {
		User usr = this.repo.findById(id).get();
		usr.setPassword(data.getPassword());
		usr.setUsername(data.getUsername());
		return this.CreateUser(usr);
	}
	
	public User GetByUsername(String username) {
		return this.repo.getByUsername(username);
	}
	
	public Optional<User> GetUserById(Long id) {
		return this.repo.findById(id);
	}
	
	public List<User> GetAllUser() {
		return this.repo.findAll();
	}
	
	public void DeleteUserById(Long id) {
		this.repo.deleteById(id);
	}
	
}
