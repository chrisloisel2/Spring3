package com.example.correction.Service;

import java.util.List;

import com.example.correction.Model.UserModel;

public interface UserService {
	UserModel createUser(UserModel user);
    List<UserModel> getAllUsers();
    UserModel getUserById(Long id);
    UserModel updateUser(Long id, UserModel user);
    void deleteUser(Long id);
}
