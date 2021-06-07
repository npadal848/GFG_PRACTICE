package dfs.easy;

import java.util.Arrays;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image1 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr1 = 1;
		int sc1 = 1;
		int newColor1 = 2; // Output: [[2,2,2],[2,2,0],[2,0,1]]

		int[][] image2 = { { 0, 0, 0 }, { 0, 0, 0 } };
		int sr2 = 0;
		int sc2 = 0;
		int newColor2 = 2;

		int[][] image3 = { { 0, 0, 0 }, { 0, 0, 1 } };
		int sr3 = 0;
		int sc3 = 0;
		int newColor3 = 2;

		int[][] image4 = { { 0, 0, 0 }, { 0, 1, 0 } };
		int sr4 = 1;
		int sc4 = 1;
		int newColor4 = 2;

		printMatrix(floodFill(image1, sr1, sc1, newColor1));
		System.out.println();
		printMatrix(floodFill(image2, sr2, sc2, newColor2));
		System.out.println();
		printMatrix(floodFill(image3, sr3, sc3, newColor3));
		System.out.println();
		printMatrix(floodFill(image4, sr4, sc4, newColor4));
	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int floodArea = image[sr][sc];
		int[][] floods = new int[image.length][image[0].length];
		for (int row = 0; row < image.length; row++) {
			for (int col = 0; col < image[row].length; col++) {
				if (image[row][col] == floodArea) {
					if ((row > 0 && image[row - 1][col] == floodArea)
							|| (col < image[row].length - 1 && image[row][col + 1] == floodArea)
							|| (row < image.length - 1 && image[row + 1][col] == floodArea)
							|| (col > 0 && image[row][col - 1] == floodArea)) {
						floods[row][col] = newColor;
					}
				} else
					floods[row][col] = image[row][col];
			}
		}
		floods[sr][sc] = newColor;
		return floods;
	}

	private static void printMatrix(int[][] matrix) {
		Arrays.stream(matrix).forEach((row) -> {
			System.out.print("[");
			Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
			System.out.println("]");
		});
	}

}
