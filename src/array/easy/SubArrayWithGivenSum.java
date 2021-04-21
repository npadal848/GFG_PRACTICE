package array.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> list = subarraySum(arr, n, s);
		list.stream().forEach(num -> System.out.print(num + " "));
	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		int sum = 0;

		for (int j = 0; j < n; j++) {
			sum += arr[j];
			while (sum > s && i < j) {
				sum -= arr[i];
				i++;
			}

			if (sum == s) {
				list.add(i + 1);
				list.add(j + 1);
				return list;
			}
		}
		return list;
	}
}
