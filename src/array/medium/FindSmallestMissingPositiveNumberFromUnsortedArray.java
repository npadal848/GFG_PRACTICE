package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSmallestMissingPositiveNumberFromUnsortedArray {

	public static void main(String[] args) {
//		int[] arr = { 2, 3, -3, -2, -6, 1, 5 };
//		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr = { 0, -10, 1, 3, -20 };
//		int[] arr = { -2, -3, -6, 2, 3, 1 };
		int n = arr.length;

		System.out.println(findSmallestMissingNumber1(arr, n));
//		System.out.println(findSmallestMissingNumber2(arr, n));
//		System.out.println(findSmallestMissingNumber3(arr, n));
		System.out.println(findSmallestMissingNumber4(arr, n));
	}

//	TC - O(n^2) and SC - O(1)
	static int findSmallestMissingNumber1(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (i == arr[j]) {
					flag = true;
					continue;
				}
			}
			if (!flag)
				return i;
		}
		return n + 1;
	}

//	TC - O(n log n) and SC - O(1)
	static int findSmallestMissingNumber2(int[] arr, int n) {
		Arrays.sort(arr);
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > 0) {
				break;
			}
		}
		if (arr[i] != 1)
			return arr[i];
		int size = n - i;
		for (int j = 2; j <= size; j++) {
			i++;
			if (j != arr[i])
				return j;
		}
		return arr[n - 1] + 1;
	}

//	TC - O(n) and SC - O(n)
	static int findSmallestMissingNumber3(int[] arr, int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0)
				set.add(arr[i]);
		}
		for (int i = 1; i <= set.size(); i++) {
			if (!set.contains(i))
				return i;
		}
		List<Integer> list = new ArrayList<>(set);
		return list.get(set.size() - 1) + 1;
	}

//	TC - O(n) and SC - O(1)
	static int findSmallestMissingNumber4(int[] arr, int n) {
		int index = segregate(arr, n);
		int size = n - index;
		int[] posArray = new int[size];

		int j = 0;
		for (int i = index; i < n; i++) {
			posArray[j] = arr[i];
			j++;
		}

		return getMissingNumber(posArray, j);
	}

	static int segregate(int[] arr, int size) {
		int j = 0;

		for (int i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
		}
		return j;
	}

	static int getMissingNumber(int[] arr, int size) {

		int j = 0;
		for (int i = 0; i < size; i++) {
			int x = Math.abs(arr[i]);
			if (x - 1 < size && arr[x - 1] > 0) {
				arr[x - 1] = -(arr[x - 1]);
			}
		}

		for (int i = 0; i < size; i++) {
			if (arr[i] > 0)
				return i + 1;
		}

		return size + 1;
	}
}
