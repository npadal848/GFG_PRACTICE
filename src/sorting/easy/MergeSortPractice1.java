package sorting.easy;

import java.util.Arrays;

public class MergeSortPractice1 {

	public static void main(String[] args) {

		int[] arr1 = { 10, 15, 20 };
		int[] arr2 = { 5, 6, 6, 15 };

		int[] res = sort(arr1, arr2);
		Arrays.stream(res).forEach(num -> System.out.print(num + " "));
	}

	public static int[] sort(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr1.length;
		int[] res = new int[n + m];

		int index = 0;
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) {
				res[index++] = arr1[i];
				i++;
			} else {
				res[index++] = arr2[j];
				j++;
			}
		}

		while (i < n) {
			res[index++] = arr1[i++];
		}

		while (j < m) {
			res[index++] = arr2[j++];
		}

		return res;
	}

}
