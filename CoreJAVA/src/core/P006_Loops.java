package core;

import java.util.Scanner;

//1.for
//2.while
//3.do-while
//4.for each
public class P006_Loops {
	public static void main(String[] args) {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}

		int j = 1;
		while (j <= 5) {
			System.out.println(j);
			j++;
		}
		int k = 1;
		do {
			System.out.println(k);
			k++;
		} while (k <= 5);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter num : ");
		int num  = sc.nextInt();
		for(int i=1;i<=10;i++) {
			System.out.println(num+" X "+i+" = "+(num*i));
		}
	}
}