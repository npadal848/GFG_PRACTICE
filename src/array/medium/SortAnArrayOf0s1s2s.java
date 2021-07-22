package array.medium;

import java.util.Arrays;

public class SortAnArrayOf0s1s2s {

	public static void main(String[] args) {
		int[] nums1 = { 0, 2, 1, 2, 0 };
		int[] nums2 = { 2, 1, 2, 0 };
		int[] nums3 = { 2, 0, 2, 1, 0, 1, 2, 2, 0, 2 };

		sort1(nums1, nums1.length);
		Arrays.stream(nums1).forEach(num -> System.out.print(num + " "));
		System.out.println();
		sort2(nums2, nums2.length);
		Arrays.stream(nums2).forEach(num -> System.out.print(num + " "));
		System.out.println();

		sort3(nums3, nums3.length);
		Arrays.stream(nums3).forEach(num -> System.out.print(num + " "));
	}

//	Time: O(nlogn) and Space: O(1)
	private static void sort1(int[] nums, int n) {
		Arrays.sort(nums);
	}

//	Time: O(2n) and Space: O(1)
	private static void sort2(int[] nums, int n) {
		int zeroCount = 0;
		int oneCount = 0;
		int twoCount = 0;
		for (int num : nums) {
			switch (num) {
			case 0:
				zeroCount++;
				break;
			case 1:
				oneCount++;
				break;
			case 2:
				twoCount++;
				break;
			}
		}
		int index = 0;
		while (zeroCount-- > 0) {
			nums[index++] = 0;
		}
		while (oneCount-- > 0) {
			nums[index++] = 1;
		}
		while (twoCount-- > 0) {
			nums[index++] = 2;
		}
	}

//	Time: O(n) and Space: O(1)
	private static void sort3(int[] nums, int n) {
		int start = 0;
		int mid = 0;
		int end = n - 1;
		int temp = 0;
		while (mid <= end) {
			switch (nums[mid]) {
			case 0:
				temp = nums[start];
				nums[start] = nums[mid];
				nums[mid] = temp;
				start++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[mid];
				nums[mid] = nums[end];
				nums[end] = temp;
				end--;
				break;
			}
		}
	}

}
