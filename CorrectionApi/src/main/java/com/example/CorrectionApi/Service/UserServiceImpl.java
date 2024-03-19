package com.example.CorrectionApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.CorrectionApi.Model.UserModel;
import com.example.CorrectionApi.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
			return User.builder()
	                    .username(username)
	                    .password(passwordEncoder.encode(password))
	                    .roles("USER")
	                    .build();
	}

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel updateUser(Long id, UserModel userDetails) {
    	UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + id));
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
