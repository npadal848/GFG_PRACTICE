package sorting.easy;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPractice3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		mergeSort(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(num -> System.out.print(num + " "));

		sc.close();
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int n = mid - low + 1;
		int m = high - mid;
		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) {
			left[i] = arr[low + i];
		}

		for (int j = 0; j < m; j++) {
			right[j] = arr[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int index = low;
		while (i < n && j < m) {
			if (left[i] <= right[j])
				arr[index++] = left[i++];
			else
				arr[index++] = right[j++];
		}

		while (i < n)
			arr[index++] = left[i++];

		while (j < m)
			arr[index++] = right[j++];

	}
}
