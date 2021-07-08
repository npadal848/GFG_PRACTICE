package array.easy;

public class FlippingAnImage {

	public static void main(String[] args) {
		int[][] image1 = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }; // Output: [[1,0,0],[0,1,0],[1,1,1]]
		/*
		 * First reverse each row: [[0,1,1],[1,0,1],[0,0,0]] Then, invert the image:
		 * [[1,0,0],[0,1,0],[1,1,1]]
		 */
		int[][] image2 = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } }; // Output:

		for (int[] arr : flip(image1)) {
			for (int num : arr)
				System.out.print(num + " ");
			System.out.println();
		}
		System.out.println();
		for (int[] arr : flip(image2)) {
			for (int num : arr)
				System.out.print(num + " ");
			System.out.println();
		}
	}

	static int[][] flip(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			int n = image[i].length;
			int start = 0;
			int end = n - 1;
			while (start < end) {
				int temp = image[i][start];
				image[i][start] = 1 - image[i][end];
				image[i][end] = 1 - temp;
				start++;
				end--;
			}
			if (n % 2 == 1)
				image[i][n / 2] = 1-image[i][n / 2];
		}
		return image;
	}
}
