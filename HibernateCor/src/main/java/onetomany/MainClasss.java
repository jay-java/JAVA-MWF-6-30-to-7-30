package onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClasss {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Student1 s1 = new Student1();
		s1.setId(1);
		s1.setName("java");
		s1.setContact(98654321);
		
		Mobile1 m1 = new Mobile1();
		m1.setMid(1);
		m1.setModel("samsung");
		m1.setConfig("8gb 128gb");
		
		Mobile1 m2 = new Mobile1();
		m2.setMid(2);
		m2.setModel("apple");
		m2.setConfig("8gb 128gb");
		

		List<Mobile1> list = new ArrayList<Mobile1>();
		list.add(m1);
		list.add(m2);
		
		s1.setMobile(list);
		m1.setStudent(s1);
		m2.setStudent(s1);
		
		session.save(s1);
		session.save(m1);
		session.save(m2);
		
		tx.commit();
		session.close();
		sf.close();
	}
}
