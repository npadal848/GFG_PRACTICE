package array.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSumUnsortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 2, 7, 11, 5 };
		int target1 = 9;
		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;

		Arrays.stream(twoSum(nums1, target1)).forEach(num -> System.out.print(num + " "));
		System.out.println();
		Arrays.stream(twoSum(nums2, target2)).forEach(num -> System.out.print(num + " "));
		System.out.println();
	}

	static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int key = 0; key < nums.length; key++) {
			if (map.containsKey(target - nums[key]))
				return new int[] { map.get(target - nums[key]), key };
			map.put(nums[key], key);
		}
		return new int[2];
	}
}
