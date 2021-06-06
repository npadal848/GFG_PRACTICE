package hashing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 2, 1, 1, 3 }; // Output: true

//		Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

		int[] arr2 = { 1, 2 }; // Output: false

		int[] arr3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }; // Output: true

		System.out.println(uniqueOccurrences1(arr1));
		System.out.println(uniqueOccurrences1(arr2));
		System.out.println(uniqueOccurrences1(arr3));
		System.out.println();
		System.out.println(uniqueOccurrences2(arr1));
		System.out.println(uniqueOccurrences2(arr2));
		System.out.println(uniqueOccurrences2(arr3));
	}

//	Time: O(n) and Space: O(n)
	static boolean uniqueOccurrences1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr)
			map.put(num, map.getOrDefault(num, 0) + 1);
		Set<Integer> set = new HashSet<>(map.values());
		return (set.size() == map.values().size());
	}

//	Time: O(n) and Space: O(n)  // improved Solution
	static boolean uniqueOccurrences2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr)
			map.put(num, map.getOrDefault(num, 0) + 1);

		Set<Integer> set = new HashSet<>();
		for (int num : map.values())
			if (!set.add(num))
				return false;
		return true;
	}

}
