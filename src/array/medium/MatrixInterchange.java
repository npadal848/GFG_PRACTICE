package array.medium;

import java.util.Scanner;

public class MatrixInterchange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				arr[i][j] = sc.nextInt();
		}
		
		System.out.println();
	}
	
	static void print(int[] arr) {
		
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
	}
}
