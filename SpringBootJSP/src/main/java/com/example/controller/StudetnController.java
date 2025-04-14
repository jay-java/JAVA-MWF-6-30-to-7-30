package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Student;
import com.example.service.StudetnService;

@Controller
public class StudetnController {

	@Autowired
	private StudetnService service;
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute Student s) {
		System.out.println(s);
		this.service.insetStudent(s);
		return "index";
	}
}
