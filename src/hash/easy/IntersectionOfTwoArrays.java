package hash.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] nums3 = { 4, 9, 5 };
		int[] nums4 = { 9, 4, 9, 8, 4 };

		Arrays.stream(intersection(nums1, nums2)).forEach(num -> System.out.print(num + " "));
		System.out.println();
		Arrays.stream(intersection(nums3, nums4)).forEach(num -> System.out.print(num + " "));
	}

	static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		return Arrays.stream(nums2).distinct().filter(num -> set1.contains(num)).toArray();
	}
}
