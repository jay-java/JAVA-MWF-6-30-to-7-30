package core;

//1.Explicit
//2.Implicit
public class P003_TypeCasting {
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		double c = (double) a / (double) b;
		System.out.println(c);

		int i = (int)3.14;
		System.out.println(i);
		
		int q = 12;
		double d = q;
		System.out.println(d);
	}
}
