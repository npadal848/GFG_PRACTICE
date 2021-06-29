package hashing.hard;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k1 = 3; // Output: [3,3,5,5,6,7]

		int[] nums2 = { 1 };
		int k2 = 1; // Output: [1]

		int[] nums3 = { 1, -1 };
		int k3 = 1; // Output: [1,-1]

		int[] nums4 = { 9, 11 };
		int k4 = 2; // Output: [11]

		int[] nums5 = { 4, -2 };
		int k5 = 2; // Output: [4]

		System.out.println(maxWindow1(nums1, k1));
		System.out.println(maxWindow1(nums2, k2));
		System.out.println(maxWindow1(nums3, k3));
		System.out.println(maxWindow1(nums4, k4));
		System.out.println(maxWindow1(nums5, k5));
	}

//	Time: O(nk) and Space: O(n/k)
	static List<Integer> maxWindow1(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= nums.length - k; i++) {
			int maxWindow = nums[i];
			if (k == 1) {
				list.add(maxWindow);
				continue;
			}
			for (int j = i + 1; j < i + k; j++) {
				maxWindow = Math.max(maxWindow, nums[j]);
			}
			list.add(maxWindow);
		}
		return list;
	}

//	Time: O(n) and Space: O(n/k)
	static List<Integer> maxWindow2(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		// will implement
		return list;
	}
}
