package topointer.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 }; // Output: [2,2]

		int[] nums3 = { 4, 9, 5 };
		int[] nums4 = { 9, 4, 9, 8, 4 }; // Output: [4,9]

		Arrays.stream(intersect(nums1, nums2)).forEach(num -> System.out.print(num + " "));
		System.out.println();
		Arrays.stream(intersect(nums3, nums4)).forEach(num -> System.out.print(num + " "));
		System.out.println();
	}

	private static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<>();
		List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
		for (int num : nums2) {
			if (list.contains(num)) {
				res.add(num);
				list.remove((Integer) num);
			}
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}
}
