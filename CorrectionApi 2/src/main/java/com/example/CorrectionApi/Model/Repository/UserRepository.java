package com.example.CorrectionApi.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CorrectionApi.Model.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// Methodes
	
	User getByUsername(String username);
	//Optional<User> FindUserByUsernameAndPassword(String username, String password);
}
