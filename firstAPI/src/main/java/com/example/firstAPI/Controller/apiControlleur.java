package com.example.firstAPI.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiControlleur {
	
	@GetMapping("/sports")
	public List<String> getAllSports()
	{
		return List.of("Foot", "MMA", "Dance");
	}
	

}
