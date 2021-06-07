package math.easy;

public class IslandPerimeter {

//	https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution
	public static void main(String[] args) {

		int[][] grid1 = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }; // Output: 16

		int[][] grid2 = { { 1 } }; // Output: 4

		int[][] grid3 = { { 1, 0 } }; // Output: 4
		
		System.out.println(islandPerimeter(grid1));
		System.out.println(islandPerimeter(grid2));
		System.out.println(islandPerimeter(grid3));
	}

	private static int islandPerimeter(int[][] grid) {
		int islandPerimeter = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == 1) {
					islandPerimeter += 4;
					if (row < grid.length - 1 && grid[row + 1][col] == 1)
						islandPerimeter -= 2;
					if (col < grid[row].length - 1 && grid[row][col + 1] == 1)
						islandPerimeter -= 2;
				}
			}
		}

		return islandPerimeter;
	}
}
