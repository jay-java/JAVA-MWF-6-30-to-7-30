package core;

import java.util.Scanner;

class FirstClass {
	public void call() {
		System.out.println("call function");
	}
}

public class P004_UserInput {
	public static void main(String[] args) {
		System.out.println("main method");
		FirstClass f = new FirstClass();
		f.call();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a = ");
		int a = sc.nextInt();
		System.out.println(a);
		System.out.println("enter double value = ");
		double d = sc.nextDouble();
		System.out.println(d);
	}
}
