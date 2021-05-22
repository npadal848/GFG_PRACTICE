package topointer.easy;

import java.util.Arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		int[] nums1 = { 0, 1, 0, 3, 12 };
		int[] nums2 = { 0 };

		moveZeroes1(nums1);
		Arrays.stream(nums1).forEach(num -> System.out.print(num + " "));
		System.out.println();
		moveZeroes1(nums2);
		Arrays.stream(nums2).forEach(num -> System.out.print(num + " "));
		System.out.println("================");
		int[] nums3 = { 0, 1, 0, 3, 12 };
		int[] nums4 = { 0 };
		moveZeroes2(nums3);
		Arrays.stream(nums3).forEach(num -> System.out.print(num + " "));
		System.out.println();
		moveZeroes2(nums3);
		Arrays.stream(nums4).forEach(num -> System.out.print(num + " "));
	}

//	TC - O(n^2) and SC - O(1)
	static void moveZeroes1(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] == 0) {
				if (nums[i + 1] != 0) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
				} else {
					int j = i + 1;
					while (j < n) {
						if (nums[j] != 0) {
							int temp = nums[i];
							nums[i] = nums[j];
							nums[j] = temp;
							break;
						}
						j++;
					}
				}
			}
		}
	}

//	TC - O(n) and SC - O(1)
	static void moveZeroes2(int[] nums) {
		int currIndex = 0;
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] != 0) {
				int temp = nums[index];
				nums[index] = nums[currIndex];
				nums[currIndex++] = temp;
			}
		}
	}
}
