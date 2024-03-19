package com.example.CorrectionApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CorrectionApi.Model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
