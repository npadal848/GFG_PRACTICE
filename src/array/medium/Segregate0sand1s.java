package array.medium;

import java.util.Scanner;

public class Segregate0sand1s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		segregate0and1(arr, n);
	}

	static void segregate0and1(int[] arr, int n) {
		int start = 0;
		int end = n - 1;

		while (start < end) {
			if (arr[start] == 1 && arr[end] == 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			} else {
				if (arr[start] == 0)
					start++;
				if (arr[end] == 1)
					end--;
			}
		}

		print(arr);
	}

	static void print(int[] arr) {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
	}
}
