package com.example.MamazonCorrection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MamazonCorrection.Model.DTO.LogsDTO;
import com.example.MamazonCorrection.Model.DTO.UserDTO;
import com.example.MamazonCorrection.Service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService service;

	@Autowired
	public UserController(UserService service)
	{
		this.service = service;
	}

	@GetMapping("/{id}")
	public UserDTO getUser(@PathVariable("id") long id)
	{
		System.out.print(id);
		return this.service.getUser(id);
	}

	@GetMapping
	public List<UserDTO> getAllUser()
	{
		return service.getAllUser();
	}

	@PostMapping
	public UserDTO createUser(@RequestBody UserDTO user)
	{
		return service.createUser(user);
	}
	
	
	@PostMapping("/register")
	public UserDTO registerUser(@RequestBody UserDTO user)
	{
		return service.createUser(user);
	}
	
	@PostMapping("/login")
	public UserDTO loginUser(@RequestBody LogsDTO user)
	{
		return service.login(user);
	}


	@PutMapping("/{id}")
	public UserDTO updateUser(@RequestBody UserDTO user, @PathVariable("id") Long id)
	{
		return service.updateUser(user, id);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		service.deleteUser(id);
	}

}
