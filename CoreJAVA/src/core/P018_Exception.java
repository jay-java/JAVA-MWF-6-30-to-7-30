package core;

import java.util.InputMismatchException;
import java.util.Scanner;

class Divide { // A
	public void division() throws ArithmeticException, InputMismatchException, Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a = ");
		int a = sc.nextInt();
		System.out.println("enter b = ");
		int b = sc.nextInt();
		if (b > 0) {
			int c = a / b;
			System.out.println("c = " + c);
		} else {
			throw new ArithmeticException();
		}

	}
}

public class P018_Exception { // B
	public static void main(String[] args) {
		try {
			Divide d = new Divide();
			d.division();
		} catch (ArithmeticException e) {

		} catch (InputMismatchException e) {

		} catch (Exception e) {

		}

//		try {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("enter a = ");
//			int a = sc.nextInt();
//			System.out.println("enter b = ");
//			int b = sc.nextInt();
//			int c = a / b;
//			System.out.println("c = " + c);
//			System.exit(0);
//		} catch (ArithmeticException e) {
//			System.out.println("denominator should be > 0");
//		} catch (InputMismatchException e) {
//			System.out.println("dnominator should be numeric value");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("this will executes everytime");
//		}
	}
}
