package array.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumOrTriplate {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };

		System.out.println(findTriplates1(arr));
		System.out.println(findTriplates2(arr));
	}

//	Time: O(n^3) and Space: O(1)
	private static Set<List<Integer>> findTriplates1(int[] arr) {
		Set<List<Integer>> triplets = new HashSet<>();
		int n = arr.length;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if ((arr[i] + arr[j] + arr[k]) == 0) {
						List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
						Collections.sort(list);
						triplets.add(list);
					}
				}
			}
		}
		return triplets;
	}

//	Time: O(n^2) and Space: O(m log n)
	private static Set<List<Integer>> findTriplates2(int[] arr) {
		Set<List<Integer>> triplets = new HashSet<>();
		boolean found = false;
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			// Find all pairs with sum equals to
			// "-arr[i]"
			HashSet<Integer> s = new HashSet<Integer>();
			for (int j = i + 1; j < n; j++) {
				int x = -(arr[i] + arr[j]);
				if (s.contains(x)) {
					List<Integer> list = Arrays.asList(x, arr[i], arr[j]);
					Collections.sort(list);
					triplets.add(list);
					found = true;
				} else {
					s.add(arr[j]);
				}
			}
		}

		if (found == false) {
			System.out.printf(" No Triplet Found\n");
		}
		return triplets;
	}
}
