package hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 2 }; // Output: 4

		int[] nums2 = { 1, 1, 1, 1, 1 }; // Output: 0

		int[] nums3 = { 1, 2, 3, 4, 5 }; // Output: 15

		System.out.println(sumOfUnique1(nums1));
		System.out.println(sumOfUnique1(nums2));
		System.out.println(sumOfUnique1(nums3));
		System.out.println("=============");
		System.out.println(sumOfUnique2(nums1));
		System.out.println(sumOfUnique2(nums2));
		System.out.println(sumOfUnique2(nums3));
		System.out.println("==============");
		System.out.println(sumOfUnique3(nums1));
		System.out.println(sumOfUnique3(nums2));
		System.out.println(sumOfUnique3(nums3));
	}

//	Time: O(n) and Space: O(n)
	static int sumOfUnique1(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int key : map.keySet()) {
			if (map.get(key) == 1)
				sum += key;
		}
		return sum;
	}

//	Time: O(n) and Space: O(n) // Improved Solution
	static int sumOfUnique2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int num : nums) {
			if (!map.containsKey(num)) {
				sum += num;
			} else if (map.getOrDefault(num, 0) == 1)
				sum -= num;
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return sum;
	}

//	Time: O(n) and Space: O(1) // Improved Solution
	static int sumOfUnique3(int[] nums) {
		int[] map = new int[101];
		int sum = 0;
		for (int num : nums) {
			if (map[num] == 0) {
				sum += num;
			} else if (map[num] == 1)
				sum -= num;
			map[num]++;
		}
		return sum;
	}
}
