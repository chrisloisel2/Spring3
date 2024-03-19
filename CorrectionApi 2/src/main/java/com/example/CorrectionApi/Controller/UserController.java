package com.example.CorrectionApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CorrectionApi.Model.Entity.User;
import com.example.CorrectionApi.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping()
	public List<User> GetAllUser() {
		return this.service.GetAllUser();
	}

	@GetMapping("/id/{id}")
	public Optional<User> GetUserById(@PathVariable Long id) {
		return this.service.GetUserById(id);
	}
	
	@GetMapping("/{username}")
	public User GetUserByUsername(@PathVariable String username) {
		return this.service.GetByUsername(username);
	}

	@PostMapping()
	public User CreateUser(@RequestBody User user) {
		return this.service.CreateUser(user);
	}

	@PutMapping("/{id}")
	public User UpdateUser(@PathVariable Long id, @RequestBody User user) {
		return this.service.UpdateUser(user, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteUser(@PathVariable Long id) {
		this.service.DeleteUserById(id);
	}

}
