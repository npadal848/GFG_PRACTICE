package sorting.easy;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		sort(arr, 0, n - 1);

		Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pIndex = partition(arr, low, high);
			sort(arr, low, pIndex - 1);
			sort(arr, pIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];

		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				shift(arr, i, j);
			}
		}
		shift(arr, i+1, high);
		return i+1;
	}

	private static void shift(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
