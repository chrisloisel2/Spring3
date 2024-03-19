package com.example.correction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.Model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
