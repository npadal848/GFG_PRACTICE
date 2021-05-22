package sorting.easy;

import java.util.Arrays;

public class SqureOfSortedArray {

	public static void main(String[] args) {
		int[] arr = { -7, -3, 2, 13, 11 };
		Arrays.stream(sortedSquares(arr)).forEach(ele -> System.out.print(ele + " "));
	}

	static int[] sortedSquares(int[] arr) {
		int[] res = new int[arr.length];
		int start = 0, end = arr.length - 1;
		int resIndex = arr.length - 1;

		while (start <= end) {
			if (arr[start] * arr[start] > arr[end] * arr[end]) {
				res[resIndex--] = arr[start] * arr[start];
				start++;
			} else {
				res[resIndex--] = arr[end] * arr[end];
				end--;
			}
		}

		return res;
	}
}
