package core;

import java.util.ArrayList;
import java.util.List;

class User{
	private int id;
	private String name;
	private long contact;
	private String address;
	
	public User(int id, String name, long contact, String address) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
	}
	
}
public class P027_ListPractical {
	public static void main(String[] args) {
		User u1=  new User(1, "dhruvil",98765432, "ahmedabad");
		User u2=  new User(2, "pavan",98765432, "ahmedabad");
		User u3=  new User(3, "mihir",98765432, "ahmedabad");
		User u4=  new User(4, "ayushi",98765432, "ahmedabad");
		User u5=  new User(5, "shreya",98765432, "ahmedabad");
		
		List<User> userList = new ArrayList<User>();
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		userList.add(u5);
		
		System.out.println(userList);
		
		for(User u:userList) {
			System.out.println(u);
		}
		
	}
}
