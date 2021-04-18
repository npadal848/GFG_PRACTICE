package array.medium;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayToRightByKPlaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

//		rotateArrayToRight1(arr, n, k);
		rotateArrayToRight2(arr, n, k);
		Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
	}

//	TC - O(nd) SC - O(1)
	static void rotateArrayToRight1(int[] arr, int n, int k) {
		for (int i = 0; i < k; i++) {
			rotate(arr, n);
		}
	}

	static void rotate(int[] arr, int n) {
		int temp = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = temp;
	}

//	TC - O(n) SC - O(1)
	static void rotateArrayToRight2(int[] arr, int n, int k) {
		if (n == 1)
			return;

		int size = n - 1;
		if (size < k) {
			reverse(arr, size - k + 1, size);
			reverse(arr, 0, size - k);
			reverse(arr, 0, size);
		}
		reverse(arr, size - k + 1, size);
		reverse(arr, 0, size - k);
		reverse(arr, 0, size);
	}

	static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}