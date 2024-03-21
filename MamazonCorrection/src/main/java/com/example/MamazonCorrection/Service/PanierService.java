package com.example.MamazonCorrection.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MamazonCorrection.Model.DTO.PanierDTO;
import com.example.MamazonCorrection.Model.Entity.Panier;
import com.example.MamazonCorrection.Model.Repository.PanierRepository;
import com.example.MamazonCorrection.Model.Repository.UserRepository;

@Service
public class PanierService {

	private final PanierRepository repo;
	
	private final UserRepository repoUser;


	@Autowired
	public PanierService(PanierRepository repo, UserRepository repoUser)
	{
		this.repo = repo;
		this.repoUser = repoUser;
	}

	// get by id
	public PanierDTO getPanier(Long id)
	{
		return convertToDTO(repo.findById(id).get());
	}

	// get all
	public List<PanierDTO> getAllPanier()
	{
		return repo.findAll().stream().map(elem->convertToDTO(elem)).toList();
	}

	// Post
	public PanierDTO createPanier(PanierDTO panier)
	{
		return convertToDTO(repo.save(convertToPanier(panier)));
	}


	// Update Panier
	public PanierDTO updatePanier(PanierDTO panier, Long id)
	{
		Panier bdd = repo.findById(id).get();
		
		bdd.setItem(panier.getListe());
	
		return convertToDTO(repo.save(bdd));
	}

	// Delete Panier
	public void deletePanier(Long id)
	{
		repo.deleteById(id);
	}
	
	
	public PanierDTO convertToDTO(Panier panier)
	{
		return new PanierDTO(panier.getId(), panier.getUser().getId(), panier.getItem());	
	}
	
	public Panier convertToPanier(PanierDTO panier)
	{
		var user = repoUser.findById(panier.getUserId()).get();
		return new Panier(panier.getId(), user, panier.getListe());
		
	}
}
