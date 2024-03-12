package com.example.firstAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstAPI.Service.SportService;

@RestController
public class apiControlleur {
	
	@Autowired
	private SportService sport;
	
	@GetMapping("/sports")
	public List<String> getAllSports()
	{
		return sport.getData();
	}
	
	@PostMapping("/sports")
	public List<String> postAllSports(@RequestBody String body)
	{
		return sport.add(body);
	}
	
	@PutMapping("/sports")
	public String getAllSpor()
	{
		return "PUT done";
	}
	
	@DeleteMapping("/sports")
	public String getAllSp()
	{
		return "Delete";
	}

}
