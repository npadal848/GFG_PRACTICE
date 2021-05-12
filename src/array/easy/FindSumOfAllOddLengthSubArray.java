package array.easy;

public class FindSumOfAllOddLengthSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 3 };
//		int[] arr = { 1, 2 };
		int n = arr.length;

		System.out.println(sum(arr, n));
	}

	static int sum(int[] arr, int n) {
		int res = 0;

		for (int i = 1; i < n; i++) {
			arr[i] += arr[i - 1];
		}

		for (int start = 0; start < n; start++) {
			for (int end = start; end < n; end += 2) {
				res += sumBetween(arr, start, end);
			}
		}

		return res;
	}

	static int sumBetween(int[] arr, int start, int end) {
		if (start == 0)
			return arr[end];
		else
			return arr[end] - arr[start - 1];
	}
}
