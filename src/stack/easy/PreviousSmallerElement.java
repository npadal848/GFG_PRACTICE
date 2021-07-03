package stack.easy; 

public class PreviousSmallerElement {

	public static void main(String[] args) {
		int[] nums1 = { 5, 15, 10, 8, 6, 12, 9, 18 };
		int[] nums2 = { 10, 15, 20, 25 };
		int[] nums3 = { 25, 20, 15, 10 };
		
		prevSmallerEle(nums1);
		prevSmallerEle(nums2);
		prevSmallerEle(nums3);
	}

//	Time: O(n^2) and Space: O(1)
	static void prevSmallerEle(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					System.out.print(nums[j] + " ");
					break;
				}
			}
			if (j == -1)
				System.out.print(-1 + " ");
		}
		System.out.println();
	}
}
