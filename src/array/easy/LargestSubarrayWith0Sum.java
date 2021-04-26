package array.easy;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {

	public static void main(String[] args) {
//		int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
//		int arr[] = {1, 2, 3};
		int arr[] = { 1, 0, 3 };
		int n = arr.length;

		System.out.println(largestSubArray1(arr, n));
		System.out.println(largestSubArray2(arr, n));
	}

//	TC - O(n^2) and SC - O(1)
	static int largestSubArray1(int[] arr, int n) {
		int maxLenth = 0;

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == 0)
					maxLenth = Math.max(maxLenth, (j - i) + 1);
			}
		}
		return maxLenth;
	}

//	TC - O(n) and SC - O(n)
	static int largestSubArray2(int[] arr, int n) {
		int maxLength = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (arr[i] == 0 && maxLength == 0) {
				maxLength = 1;
			}

			if (sum == 0) {
				maxLength = i + 1;
			}

			if (map.containsKey(sum)) {
				maxLength = Math.max(maxLength, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return maxLength;
	}
}
