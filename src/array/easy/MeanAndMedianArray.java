package array.easy;

import java.util.Arrays;

public class MeanAndMedianArray {

	public static void main(String[] args) {
//		int n = 5;
//		int[] arr = {1, 2, 19, 28, 5};
		int n = 4;
		int[] arr = { 2, 8, 3, 4 };
		System.out.println(mean(arr, n));
		System.out.println(median(arr, n));
	}

	static int median(int A[], int N) {
		Arrays.sort(A);
		int mid = N / 2;
		if (N % 2 == 0) {
			return (A[mid] + A[mid - 1]) / 2;
		} else
			return A[mid];
	}

	// Function to find median of the array elements.
	static int mean(int A[], int N) {
		int sum = 0;
		for (int num : A)
			sum += num;

		return sum / N;
	}
}
