package core;

import java.util.Scanner;

public class P008_Array {
	public static void main(String[] args) {
		int i[] = { 1, 2, 3, 4, 5 };
		for (int index = 0; index < i.length; index++) {
			System.out.println(i[index]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array : ");
		int size = sc.nextInt();
		int a[] = new int[size];
		for (int index = 0; index < a.length; index++) {
			System.out.print("enter element at a[" + index + "] : ");
			a[index] = sc.nextInt();
		}
		int sum = 0;
		for (int index = 0; index < a.length; index++) {
			sum = sum + a[index];
		}
		System.out.println("sum = " + sum);
		System.out.println("enter number to search in array : ");
		int num = sc.nextInt();
		int counter = 0;
		for (int index = 0; index < a.length; index++) {
			if (num == a[index]) {
				counter++;
			}

		}
		if (counter > 0) {
			System.out.println("yes exist " + counter + " times");
		} else {
			System.out.println("not exist");
		}

		int ar[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int r = 0; r < ar.length; r++) {
			for (int c = 0; c < ar.length; c++) {
				System.out.print(ar[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println("enter num of row : ");
		int row = sc.nextInt();
		System.out.println("etner num of col : ");
		int col = sc.nextInt();
		int arr[][] = new int[row][col];
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				System.out.print("enter element at [" + r + "][" + c + "] : ");
				arr[r][c] = sc.nextInt();
			}
		}
	}
}