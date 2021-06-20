package hashing.medium;

import java.util.HashMap;

public class LargestZeroSumSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, -1, 3, 2, -2, -8, 1, 7, 10, 23 };
		System.out.println(subArray(arr));
	}

	private static int subArray(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				res = i + 1;
			} else {
				if (map.containsKey(sum)) {
					res = Math.max(res, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}
		}
		return res;
	}
}
