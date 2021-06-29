package hashing.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		System.out.println(thirdMax(nums));
		sc.close();
	}

	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.add(num)) {
				queue.offer(num);
				if (queue.size() > 3)
					queue.poll();
			}
		}
		if (queue.size() == 2)
			queue.poll();
		return queue.peek();
	}
}
