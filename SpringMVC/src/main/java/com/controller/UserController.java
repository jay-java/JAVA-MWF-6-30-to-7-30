package com.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {

	@RequestMapping("/")
	public String indexPage(Model m) {
		List<User> list = this.dao.getAllUser();
		m.addAttribute("list", list);
		return "index";
	}

//	@RequestMapping("/about")
//	public String aboutPage(HttpServletRequest request) {
//		request.setAttribute("num", 123);
//		return "about";
//	}
//
//	@RequestMapping("/about")
//	public String aboutPage(Model m) {
//		m.addAttribute("num", 1234);
//
//		List list = Arrays.asList(new User(1, "java", 98654132, "ahmedabad"), new User(2, "php", 98654132, "ahmedabad"),
//				new User(3, "dart", 98654132, "ahmedabad"), new User(4, "kotlin", 98654132, "ahmedabad"),
//				new User(5, "python", 98654132, "ahmedabad"));
//		
//		m.addAttribute("list", list);
//		return "about";
//	}

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}

//	@RequestMapping("/insert")
//	public void insertUser(HttpServletRequest request) {
//		User u =new User();
//		u.setName(request.getParameter("name"));
//		u.setContact(Long.parseLong(request.getParameter("contact")));
//		u.setEmail(request.getParameter("email"));
//		u.setPassword(request.getParameter("password"));
//		System.out.println(u);
//		
//	}

//	@RequestMapping("/insert")
//	public void insertUser(@RequestParam("name") String name,
//			@RequestParam("contact") long contact
//			) {
//		
//		System.out.println(name + contact);
//		
//	}
	
	@Autowired
	private UserDao dao;

	@RequestMapping("/insert")
	public String insertUser(@ModelAttribute User u,Model m) {
		this.dao.saveOrUpdateUser(u);
		List<User> list = this.dao.getAllUser();
		m.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id,Model m) {
		this.dao.deleteUser(id);
		List<User> list = this.dao.getAllUser();
		m.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") int id) {
		User u = this.dao.getUserById(id);
		ModelAndView m = new ModelAndView();
		m.addObject("u", u);
		m.setViewName("update");
		return m;
	}
	
	
}
