package com.orm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void saveOrUpdateUser(User u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}
	@Transactional
	public void deleteUser(int id) {
		User u = this.hibernateTemplate.get(User.class, id);
		this.hibernateTemplate.delete(u);
	}
	
	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}
	
	
	public List<User> getAllUser(){
		return this.hibernateTemplate.loadAll(User.class);
	}

	
}
