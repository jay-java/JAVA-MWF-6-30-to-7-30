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
		String q1 = String.valueOf(q);
		System.out.println(d);
		
		String n1 = "12";
		int n2  = Integer.parseInt(n1);
		String n3 = "23.23";
		double n4 = Double.parseDouble(n3);
	}
}
