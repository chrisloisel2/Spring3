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

import com.example.MamazonCorrection.Model.DTO.PanierDTO;
import com.example.MamazonCorrection.Service.PanierService;

@CrossOrigin("*")
@RestController
@RequestMapping("/paniers")
public class PanierController {
	
	private final PanierService service;

	@Autowired
	public PanierController(PanierService service)
	{
		this.service = service;
	}

	@GetMapping("/{id}")
	public PanierDTO getPanier(@PathVariable Long id)
	{
		return this.service.getPanier(id);
	}

	@GetMapping
	public List<PanierDTO> getAllPanier()
	{
		return service.getAllPanier();
	}

	@PostMapping
	public PanierDTO createPanier(@RequestBody PanierDTO panier)
	{
		return service.createPanier(panier);
	}



	@PutMapping("/{id}")
	public PanierDTO updatePanier(@RequestBody PanierDTO panier, @PathVariable Long id)
	{
		return service.updatePanier(panier, id);
	}

	@DeleteMapping("/{id}")
	public void deletePanier(@PathVariable Long id)
	{
		service.deletePanier(id);
	}

}
