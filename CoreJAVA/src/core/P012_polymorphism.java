package core;
class Call{
	public int add(int a,int b) {
		return a+b;
	}
//	public int add(int a,String b) {
//		return a+b;
//	}
	public int add(int a,int b,int c) {
		return a+b+c;
	}
	public int add(int a,int b,int c,int d) {
		return a+b+c+d;
	}
}
class Parent{
	public void show(int i) {
		System.out.println("show in parent");
	}
}
class Child extends Parent{
	public void show(int a) {
		super.show(13);
		System.out.println("show in child");
	}
}
public class P012_polymorphism {
	public static void main(String[] args) {
		Call c = new Call();
		int res =  c.add(1, 2, 3);
		System.out.println(res);
		
		Child c1 = new Child();
		c1.show(12);
		
	}
	
}
