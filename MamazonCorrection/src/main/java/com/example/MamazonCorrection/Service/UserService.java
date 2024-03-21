package com.example.MamazonCorrection.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MamazonCorrection.Model.DTO.LogsDTO;
import com.example.MamazonCorrection.Model.DTO.UserDTO;
import com.example.MamazonCorrection.Model.Entity.Panier;
import com.example.MamazonCorrection.Model.Entity.User;
import com.example.MamazonCorrection.Model.Repository.PanierRepository;
import com.example.MamazonCorrection.Model.Repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repo;
	private final PanierRepository repoPanier;


	@Autowired
	UserService(UserRepository repo, PanierRepository repoPanier)
	{
		this.repo = repo;
		this.repoPanier = repoPanier;
	}

	// get by id
	public UserDTO getUser(Long id)
	{
		return convertToDTO(repo.findById(id).orElse(new User()));
	}

	// get all
	public List<UserDTO> getAllUser()
	{
		return repo.findAll().stream().map(usr->convertToDTO(usr)).toList();
	}

	// Post
	public UserDTO createUser(UserDTO user)
	{
		var usercov = convertToUser(user);
		usercov = repo.save(usercov);
		return convertToDTO(usercov);
		
	}
	
	public UserDTO login(LogsDTO user)
	{
		return convertToDTO(repo.findByNameAndPassword(user.getName(), user.getPassword()).get());
	}


	// Update User
	public UserDTO updateUser(UserDTO user, Long id)
	{
		var userNormal = convertToUser(user);
		
		var bddUser = repo.findById(id).get();
	
		bddUser.setAge(user.getAge());
		bddUser.setEmail(user.getEmail());
		bddUser.setName(user.getName());
		bddUser.setPassword(user.getPassword());
		bddUser.setPanier(userNormal.getPanier());
	
	
	
		return convertToDTO(repo.save(bddUser));
	}

	// Delete User
	public void deleteUser(Long id)
	{
		repo.deleteById(id);
	}

	public UserDTO convertToDTO(User user)
	{
		if (user.getPanier() == null)
		{
			user.setPanier(repoPanier.save(new Panier()));
			
		}
		return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getAge(), user.getPanier().getId());
	}

	public User convertToUser(UserDTO user)
	{
		Panier panier = repoPanier.findById(user.getPanier()).orElse(
				repoPanier.save(new Panier()));
		return new User(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getAge(), panier);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
