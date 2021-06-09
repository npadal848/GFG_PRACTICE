package hashing.easy;

//https://leetcode.com/problems/single-number/
public class SingleNumber {

	public static void main(String[] args) {
		int[] nums1 = { 2, 2, 1 }; // Output: 1

		int[] nums2 = { 4, 1, 2, 1, 2 }; // Output: 4

		int[] nums3 = { 1 }; // Output: 1

		System.out.println(singleNumber1(nums1));
		System.out.println(singleNumber1(nums2));
		System.out.println(singleNumber1(nums3));
		System.out.println();
		System.out.println(singleNumber2(nums1));
		System.out.println(singleNumber2(nums2));
		System.out.println(singleNumber2(nums3));
	}

//	Time: O(n) and Space: O(1) : Two time traversal
	private static int singleNumber1(int[] nums) {
		int countTable[] = new int[60000];
		for (int num : nums) {
			countTable[num + 30000]++;
		}
		for (int i = 0; i < countTable.length; i++)
			if (countTable[i] == 1)
				return i - 30000;
		return 0;
	}
	
//	Time: O(n) and Space: O(1) : Improved solution
	private static int singleNumber2(int[] nums) {
        int res=0;
		for (int num : nums)
			res^=num;
		return res;
    }
}
