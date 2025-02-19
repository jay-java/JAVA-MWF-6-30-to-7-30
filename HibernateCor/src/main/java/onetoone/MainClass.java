package onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Student s1 =new Student();
		s1.setId(1);
		s1.setName("java");
		s1.setContact(98654321);

		Mobile m1 = new Mobile();
		m1.setMid(1);
		m1.setModel("samsung");
		m1.setConfig("8gb 128gb");
		
		s1.setMobile(m1);
		m1.setStudent(s1);
		
		session.save(s1);
		session.save(m1);
		
		tx.commit();
		session.close();
		sf.close();
	}
}
