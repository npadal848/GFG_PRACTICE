package array.basic;

import java.util.Scanner;

public class RemoveDuplicateFromASortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

//		int size = removeDuplicate1(arr, n);
		int size = removeDuplicate2(arr, n);
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

//	TC - O(n) and SC - O(n)
	static int removeDuplicate1(int arr[], int n) {
		if (n == 0 || n == 1)
			return n;
		int[] temp = new int[n];
		int index = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				temp[index++] = arr[i];
			}
		}
		temp[index++] = arr[n - 1];
		for (int i = 0; i < index; i++) {
			arr[i] = temp[i];
		}
		return index;
	}

//	TC - O(n) and SC - O(1)
	static int removeDuplicate2(int arr[], int n) {
		if (n == 0 || n == 1)
			return n;
		int index = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[index++] = arr[i];
			}
		}
		arr[index++] = arr[n - 1];
		return index;
	}
}
