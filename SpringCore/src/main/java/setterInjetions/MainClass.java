package setterInjetions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("setterInjetions/setter.xml");
		user u1 =(user)con.getBean("u1");
		System.out.println(u1);
	}
}
