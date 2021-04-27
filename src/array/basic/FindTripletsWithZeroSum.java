package array.basic;

import java.util.Arrays;

public class FindTripletsWithZeroSum {

	public static void main(String[] args) {
//		int arr[] = { 0, -1, 2, -3, 1 };
		int arr[] = { 0, -1, 5, -3, 1 };
//		int arr[] = { 1, 2, 3 };
		int n = arr.length;

		System.out.println(isTripletSumZero1(arr, n));
		System.out.println(isTripletSumZero2(arr, n));
	}

//	TC - O(n^2) and SC - O(1)
	static boolean isTripletSumZero1(int[] arr, int n) {

		if (n < 3)
			return false;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

//	TC - O(n^2) and SC - O(1)
	static boolean isTripletSumZero2(int[] arr, int n) {
		Arrays.sort(arr);
		for (int i = 0; i < n - 2; i++) {
			int start = i + 1;
			int end = n - 1;

			while (start < end) {
				int sum = arr[i] + arr[start] + arr[end];
				if (sum == 0) {
					return true;
				} else if (sum > 0)
					end--;
				else
					start++;
			}
		}
		return false;
	}
}
