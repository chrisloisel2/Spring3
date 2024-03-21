package com.example.MamazonCorrection.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MamazonCorrection.Model.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByNameAndPassword(String name, String password);
}