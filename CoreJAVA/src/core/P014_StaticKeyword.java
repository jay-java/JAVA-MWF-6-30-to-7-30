package core;

class Employee {
	int id;
	String name = "java";
	static String company_name = "TOPS";

	public void call() {
		System.out.println("call in employee : " + company_name+"   "+name);
	}

	public static void staticCall() {
		System.out.println("static call in employee" + company_name);
	}
}

public class P014_StaticKeyword {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.call();
		Employee.staticCall();
	}
}