package hashing.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementInArray {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		Arrays.stream(topK(nums, k)).forEach(ele -> {
			System.out.print(ele + " ");
		});
		;
	}

	public static int[] topK(int[] nums, int k) {
		int[] res = new int[k];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
				(a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
						: Integer.compare(b.getValue(), a.getValue()));

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			queue.offer(entry);

		for (int i = 0; i < k; i++) {
			res[i] = queue.poll().getKey();
		}
		return res;
	}
}
