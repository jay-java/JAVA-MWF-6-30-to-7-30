package consINjection;

public class user {
	int id;
	String name;
	String address;

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(int id, String name, String address) {
		super();
		System.out.println("set by cons");
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
