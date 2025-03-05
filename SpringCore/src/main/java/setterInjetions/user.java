package setterInjetions;

public class user {
	int id;
	String name;
	String address;

	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("set Id");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("set name");
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("set address");
		this.address = address;
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
