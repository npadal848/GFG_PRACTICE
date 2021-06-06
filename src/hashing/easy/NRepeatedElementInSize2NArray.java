package hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 3 }; // Output: 3

		int[] nums2 = { 2, 1, 2, 5, 3, 2 }; // Output: 2

		int[] nums3 = { 5, 1, 5, 2, 5, 3, 5, 4 }; // Output: 5

		System.out.println(repeatedNTimes(nums1));
		System.out.println(repeatedNTimes(nums2));
		System.out.println(repeatedNTimes(nums3));
	}

	static int repeatedNTimes(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.getOrDefault(num, 0) > 1)
				return num;
			map.put(num, map.getOrDefault(num, 1)+1);
		}
		return 0;
	}
}
