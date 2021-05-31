package sorting.easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegersByTheNumberOf1Bits {

	public static void main(String[] args) {
		int[] arr1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] arr2 = { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };
		int[] arr3 = { 10000, 10000 };
		int[] arr4 = { 2, 3, 5, 7, 11, 13, 17, 19 };

		Arrays.stream(sort2(arr1)).forEach(ele -> System.out.print(ele + " "));
		System.out.println();
		Arrays.stream(sort2(arr2)).forEach(ele -> System.out.print(ele + " "));
		System.out.println();
		Arrays.stream(sort2(arr3)).forEach(ele -> System.out.print(ele + " "));
		System.out.println();
		Arrays.stream(sort2(arr4)).forEach(ele -> System.out.print(ele + " "));
		System.out.println();
	}

	static int[] sort1(int[] arr) {
		return Arrays.stream(arr).boxed()
				.sorted((ele1, ele2) -> Integer.bitCount(ele1) != Integer.bitCount(ele2)
						? Integer.bitCount(ele1) - Integer.bitCount(ele2)
						: ele1 - ele2)
				.mapToInt(Integer::intValue).toArray();
	}

	static int[] sort2(int[] arr) {
		Integer[] arr2 = new Integer[arr.length];
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		Arrays.sort(arr2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.bitCount(o1) - Integer.bitCount(o2);
			}
		});
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr2[i];
		}
		return arr;
	}
}
