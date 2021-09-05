package sorting.easy;

import java.util.Arrays;

public class MergeSortPractice2 {

	public static void main(String[] args) {

		int[] arr = { 10, 15, 20, 25, 5, 6, 15 };

		int[] res = sort(arr, 0, 3, 6);
		Arrays.stream(res).forEach(num -> System.out.print(num + " "));
	}

	public static int[] sort(int[] arr, int low, int mid, int high) {
		int n = mid + 1;
		int m = high - mid;
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] res = new int[n + m];

		for (int i = 0; i < n; i++) {
			arr1[i] = arr[low + i];
		}

		for (int j = 0; j < m; j++) {
			arr2[j] = arr[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int index = 0;
		while (i < n && j < m) {
			if (arr1[i] <= arr2[j])
				res[index++] = arr1[i++];
			else
				res[index++] = arr2[j++];
		}

		while (i < n)
			res[index++] = arr1[i++];

		while (j < m)
			res[index++] = arr2[j++];

		return res;
	}
}
