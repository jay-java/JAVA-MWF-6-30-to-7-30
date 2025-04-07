package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public void insertOrUpdateUser(User u) {
		this.repo.save(u);
	}
	
	public List<User> getAllUsers(){
		return this.repo.findAll();
	}
	
	public Optional<User> getUserById(int id) {
		return this.repo.findById(id);
	}
	
	public User getUserByName(String name){
		return this.repo.findUserByName(name);
	}
	
	public void deleteUserById(int id) {
		this.repo.deleteById(id);
	}
}
