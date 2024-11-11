package core;

public class P007_Patterns {
	public static void main(String[] args) {
		//for row
		int num = 1;
		for(int i=1;i<=5;i++) {
			//for column
			for(int j=1;j<=i;j++) {
				System.out.print((num*num)+" ");
				num++;
			}
			System.out.println();
		}
	}
}
