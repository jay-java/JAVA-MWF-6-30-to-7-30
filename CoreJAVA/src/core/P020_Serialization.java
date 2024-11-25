package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserData implements Serializable{
	private int id;
	private String name;
	private String address;
	private long contact;

	public UserData(int id, String name, String address, long contact) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "id : "+id+" name :"+name+" address: "+address+" contact : "+contact;
	}
}

public class P020_Serialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		UserData u = new UserData(1, "java", "amd", 987654231);
		
//		FileOutputStream fos = new FileOutputStream("user.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(u);
//		oos.flush();
//		oos.close();
//		System.out.println("done");
		
		FileInputStream fis = new FileInputStream("user.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		UserData u1 = (UserData)ois.readObject();
		System.out.println(u1);
	}
}
