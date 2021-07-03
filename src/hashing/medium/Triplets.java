package hashing.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triplets {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 }; // Output: [[-1,-1,2],[-1,0,1]]

		System.out.println(getAllTriplets1(nums));
		System.out.println();
		System.out.println(getAllTriplets2(nums));
		System.out.println();
		System.out.println(getAllTriplets3(nums));
	}

//	Time: O(n^3) and Space: O(n)
	static Set<List<Integer>> getAllTriplets1(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> triplet = null;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						triplet = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(triplet);
						set.add(triplet);
					}
				}
			}
		}
		return set;
	}

//	Time: O(n^2) and Space: O(1)
	static Set<List<Integer>> getAllTriplets2(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n-2; i++) {
			int low = i + 1;
			int high = n - 1;
			int sum = 0 - nums[i];
			while (low < high) {
				if (nums[low] + nums[high] == sum) {
					res.add(Arrays.asList(nums[i], nums[low], nums[high]));
					low++;
					high--;
				} else if (nums[low] + nums[high] < sum)
					low++;
				else
					high--;
			}
		}
		return res;
	}

//	Time: O(n^2) and Space: O(1)
	static List<List<Integer>> getAllTriplets3(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int low = i + 1;
				int high = n - 1;
				int sum = 0 - nums[i];
				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1])
							low++;
						while (low < high && nums[high] == nums[high - 1])
							high--;
						low++;
						high--;
					} else if (nums[low] + nums[high] < sum) {
						while (low < high && nums[low] == nums[low + 1])
							low++;
						low++;
					} else {
						while (low < high && nums[high] == nums[high - 1])
							high--;
						high--;
					}
				}
			}
		}

		return res;
	}
}
