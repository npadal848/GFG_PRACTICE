package stack.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextGreaterEelement2 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 1 }; // Output: [2,-1,2]

//				Explanation: The first 1's next greater number is 2; 
//				The number 2 can't find next greater number. 
//				The second 1's next greater number needs to search circularly, which is also 2.

		System.out.println(nextGreaterElements1(nums1));
		System.out.println(nextGreaterElements2(nums1));
		System.out.println();
		int[] nums2 = { 1, 2, 3, 4, 3 }; // Output: [2,3,4,-1,4]
		System.out.println(nextGreaterElements1(nums2));
		System.out.println(nextGreaterElements2(nums2));
	}

//	Time: O(n^2) and Space: O(1)
	public static List<Integer> nextGreaterElements1(int[] A) {
		int[] res = new int[A.length];
		start: for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] > A[i]) {
					res[i] = A[j];
					continue start;
				}
			}

			for (int k = 0; k < i; k++) {
				if (A[k] > A[i]) {
					res[i] = A[k];
					continue start;
				}
			}
			res[i] = -1;
		}
		return Arrays.stream(res).boxed().collect(Collectors.toList());
	}

//	Time: O(n) and Space: O(n)
	public static List<Integer> nextGreaterElements2(int[] A) {
		int n = A.length, res[] = new int[n];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
				res[stack.pop()] = A[i % n];
			stack.push(i % n);
		}
		return Arrays.stream(res).boxed().collect(Collectors.toList());
	}
}
