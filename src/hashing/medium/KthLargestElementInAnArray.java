package hashing.medium;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(kthLargestEle(nums, k));
		sc.close();
	}

	static int kthLargestEle(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a==b?0:Integer.compare(b, a));
		for (int num : nums)
			queue.add(num);
		int count = 1;
		for (int ele : queue) {
			if (count == k)
				return ele;
			count++;
		}
		return -1;
	}
}
