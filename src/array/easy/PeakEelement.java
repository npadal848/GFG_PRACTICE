package array.easy;

public class PeakEelement {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int n = arr.length;

		System.out.println(peakElement(arr, n));
	}

	public static int peakElement(int[] arr, int n) {
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid == 0) {
				if (arr[mid] >= arr[mid + 1])
					return mid;
				else
					start = mid + 1;
			} else if (mid == n - 1) {
				if (arr[mid] >= arr[mid - 1])
					return mid;
			} else if (arr[mid] >= arr[mid - 1]) {
				if (arr[mid] >= arr[mid + 1])
					return mid;
				else
					start = mid + 1;

			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
