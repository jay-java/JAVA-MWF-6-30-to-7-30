package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

//@Controller
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	//@RequestMapping("/id")
	//@ResponseBody
	@GetMapping("/")
	public List<User> home() {
		List<User> list = List.of(
				new User(1,"java",9876945,"ahmedabad"),
				new User(2,"python",9876945,"ahmedabad"),
				new User(3,"php",9876945,"ahmedabad"),
				new User(4,"dart",9876945,"ahmedabad"),
				new User(5,"kotlin",9876945,"ahmedabad")
				);
		return list;
	}
	
	@PostMapping("/save")
	public String aboutpage(@RequestBody User u) {
		this.service.insertUser(u);
		return "successs";
	}
	
	@GetMapping("/allusers")
	public List<User> finAllUsers(){
		return this.service.getAllUsers();
	}
	
	@GetMapping("/allusers/{id}")
	public Optional<User> getById(@PathVariable("id") int id){
		return this.service.getUserById(id);
	}
	
	@GetMapping("/allusers/{name}")
	public Optional<User> findUserByUsername(@RequestParam("name") String name){
		System.out.println(name);
		return this.service.getUserByName(name);
	}
}
