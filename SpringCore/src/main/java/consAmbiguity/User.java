package consAmbiguity;

public class User {
	int a;
	int b;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int a, int b) {
		System.out.println("data set by int cons");
		this.a = a;
		this.b = b;
	}
	
	public User(String a,String b) {
		System.out.println("data set by String cons");
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
	}
	
	public User(double a,double b) {
		System.out.println("data set by double cons");
		this.a = (int)a;
		this.b = (int)b;
	}

	@Override
	public String toString() {
		return "User [a=" + a + ", b=" + b + "]";
	}
	
}
