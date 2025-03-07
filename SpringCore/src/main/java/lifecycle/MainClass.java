package lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		int a = 10;
		a = 20;
		AbstractApplicationContext con = new ClassPathXmlApplicationContext("lifecycle/lifecycle.xml");
		User u = (User) con.getBean("u1");
		System.out.println(u);

		User1 u2 = (User1) con.getBean("u2");
		System.out.println(u2);

		User2 u3 = (User2) con.getBean("u3");
		System.out.println(u3);

		con.registerShutdownHook();

	}
}
