package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Student2 s1 = new Student2();
		s1.setId(1);
		s1.setName("abc");
		s1.setContact(89465);

		Student2 s2 = new Student2();
		s2.setId(2);
		s2.setName("def");
		s2.setContact(89465);

		Course c1 = new Course();
		c1.setCid(1);
		c1.setCname("java");
		c1.setDuration("6 months");

		Course c2 = new Course();
		c2.setCid(2);
		c2.setCname("python");
		c2.setDuration("6 months");

		List<Student2> slist = new ArrayList<Student2>();
		slist.add(s1);
		slist.add(s2);

		List<Course> clist = new ArrayList<Course>();
		clist.add(c1);
		clist.add(c2);

		s1.setCourse(clist);
		s2.setCourse(clist);

		c1.setStudent(slist);
		c2.setStudent(slist);

		session.save(s1);
		session.save(s2);
		session.save(c1);
		session.save(c2);

		tx.commit();
		session.close();
		sf.close();
	}
}
