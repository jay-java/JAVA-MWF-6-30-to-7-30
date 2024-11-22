package core;
final class ABC{
	final int i =1;
	final public void change() {
//		i++;
		System.out.println(i+" abc in parent");
	}
}

class ABCNew extends ABC {
	public void change() {
		System.out.println("change in abc new ");
	}
}

public class P016_Final {
	public static void main(String[] args) {
		ABC a = new ABC();
		a.change();
		
		ABCNew b = new ABCNew();
		b.change();
	}
}
