package com.example.CorrectionApi.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.CorrectionApi.Model.UserModel;

public interface UserService {
	UserModel createUser(UserModel user);
    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
    UserModel updateUser(Long id, UserModel user);
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username, String password);
}
