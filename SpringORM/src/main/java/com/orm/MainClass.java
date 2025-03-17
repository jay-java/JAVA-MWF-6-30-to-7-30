package com.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("conn.xml");
		UserDao dao = (UserDao) con.getBean("dao");

//		User u = new User(2, "python", 98765313);
//		dao.saveOrUpdateUser(u);

		List<User> list = dao.getAllUser();
		System.out.println(list);
	}
}
