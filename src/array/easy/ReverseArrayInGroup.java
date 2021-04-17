package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayInGroup {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		reverseInGroups(arr, arr.size(), 3);
		System.out.println(arr);
	}

	static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		for (int i = 0; i < n; i += k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);
			while (left < right) {
				int temp = arr.get(left);
				arr.set(left, arr.get(right));
				arr.set(right, temp);
				left++;
				right--;
			}
		}
	}
}
