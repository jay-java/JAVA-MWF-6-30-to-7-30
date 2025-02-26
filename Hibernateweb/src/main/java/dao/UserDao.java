package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class UserDao {
	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();

	public void insertUser(User u) {
		session.save(u);
		tx.commit();
		session.close();
		sf.close();
	}

	public List<User> getAllUser() {
		String hql = "from User";
		Query q = session.createQuery(hql);
		List<User> list = q.list();
		return list;
	}
	
	public User getUserById(int id) {
		return session.get(User.class, id);
	}
	
	public void deleteUser(int id) {
		User u= session.get(User.class, id);
		session.delete(u);
	}
	
	public void updateUser(User u) {
		session.update(u);
		tx.commit();
		session.close();
		sf.close();
	}
	

}
