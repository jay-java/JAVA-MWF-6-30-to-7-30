package core;
class Student{
	private int id;
	private String name;
	private int std;
	
	public Student() {
		
	}
	public Student(int id,String name,int std) {
		this.id = id;
		this.name = name;
		this.std  =std;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getStd() {
		return std;
	}
	
	@Override
	public String toString() {
		return "id : "+id+" name : "+name+" std : "+std;
	}
}
public class P015_Encapsulation {
	public static void main(String[] args) {
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("python");
		s2.setStd(5);
//		System.out.println(s2.getId());
//		System.out.println(s2.getName());
//		System.out.println(s2.getStd());
		System.out.println(s2);
		
		Student s= new Student(3, "java", 7);
		System.out.println(s);
	}
}
