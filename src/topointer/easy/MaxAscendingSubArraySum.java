package topointer.easy;

public class MaxAscendingSubArraySum {

	public static void main(String[] args) {
		int[] nums1 = { 10, 20, 30, 5, 10, 50 };
		//Output: 65
		//Explanation: {5,10,50] is the ascending subarray with the maximum sum of 65.

		int[] nums2 = { 10, 20, 30, 40, 50 };
		//Output: 150
		//Explanation: {10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
		
		//Example 3:
		int[] nums3 = { 12, 17, 15, 13, 10, 11, 12 };
		//Output: 33
		//Explanation: {10,11,12] is the ascending subarray with the maximum sum of 33.
		
		//Example 4:
		int[] nums4 = { 100, 10, 1 };
		//Output: 100
		
		System.out.println(maxAscendingSum(nums1));
		System.out.println(maxAscendingSum(nums2));
		System.out.println(maxAscendingSum(nums3));
		System.out.println(maxAscendingSum(nums4));
	}

	static int maxAscendingSum(int[] nums) {
		int sum = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				sum += nums[i];
			else
				sum = nums[i];
			max = Math.max(max, sum);
		}
		return max;
	}
}
