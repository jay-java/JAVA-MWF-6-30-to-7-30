package consAmbiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("consAmbiguity/consamb.xml");
		User u1= (User)con.getBean("u1");
		System.out.println(u1);
	}
}
