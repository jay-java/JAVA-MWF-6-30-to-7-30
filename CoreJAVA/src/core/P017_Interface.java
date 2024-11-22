package core;
interface inter1{
	public void interface1();
	public static void interface11() {
		System.out.println("interface 11");
	}
}
interface inter2 extends inter1{
	public void interface2();
	public static void interface22() {
		System.out.println("interface 22");
	}
}
interface inter3{
	public void interface3();
	public static void interface33() {
		System.out.println("interface 33");
	}
}
class interCall implements inter2,inter3{

	@Override
	public void interface1() {
		// TODO Auto-generated method stub
		System.out.println("interface 1");
	}

	@Override
	public void interface3() {
		// TODO Auto-generated method stub
		System.out.println("interface 3");
	}

	@Override
	public void interface2() {
		// TODO Auto-generated method stub
		System.out.println("interface 2");
	}
	
}
public class P017_Interface {
	public static void main(String[] args) {
		interCall i = new interCall();
		i.interface1();
		i.interface2();
		i.interface3();
		inter1.interface11();
		inter2.interface22();
		inter3.interface33();
	}
}
