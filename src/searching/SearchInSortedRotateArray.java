package searching;

public class SearchInSortedRotateArray {

	public static void main(String[] args) {
		int[] arr = { 100, 200, 4, 6, 8, 10, 20 };
		int n = arr.length;
		int k = 6;

		System.out.println(search(arr, n, k));
	}

	static int search(int[] arr, int n, int k) {
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == k)
				return mid;
			else if (arr[start] < arr[mid]) {
				if (k >= arr[start] && k < arr[mid]) {
					end = mid - 1;
				} else
					start = mid + 1;
			} else {
				if (k > arr[mid] && k <= arr[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}

		return -1;
	}
}
