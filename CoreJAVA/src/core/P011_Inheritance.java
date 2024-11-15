package core;

class A{
	A(){
		System.out.println("default in A");
	}
	public void clasA() {
		System.out.println("class A");
	}
}
class B extends A{
	public void clasB() {
		System.out.println("class B");
	}
}
class C extends B{
	public void clasC() {
		System.out.println("class C");
	}
}

class D extends A{
	public void clasD() {
		System.out.println("class D");
	}
}
public class P011_Inheritance {
	public static void main(String[] args) {
		B b = new B();
		b.clasA();
		b.clasB();
	}
}
