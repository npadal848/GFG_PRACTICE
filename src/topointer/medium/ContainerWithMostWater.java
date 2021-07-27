package topointer.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 }; // Output: 49
		int[] height2 = { 1, 1 }; // Output: 1

		int[] height3 = { 4, 3, 2, 1, 4 }; // Output: 16

		int[] height4 = { 1, 2, 1 }; // Output: 2

		System.out.println(getMaxContainer1(height1));
		System.out.println(getMaxContainer1(height2));
		System.out.println(getMaxContainer1(height3));
		System.out.println(getMaxContainer1(height4));
		System.out.println();
		System.out.println(getMaxContainer2(height1));
		System.out.println(getMaxContainer2(height2));
		System.out.println(getMaxContainer2(height3));
		System.out.println(getMaxContainer2(height4));
	}

//	Time: O(n^2) and Space: O(1)
	private static int getMaxContainer1(int[] height) {
		int max = 0;
		int currMax = 0;
		int n = height.length;
		for (int i = 0; i < n; i++) {
			currMax = height[i];
			for (int j = i + 1; j < n; j++) {
				currMax = Math.max(currMax, Math.min(height[i], height[j]) * (j - i));
			}
			max = Math.max(max, currMax);
		}
		return max;
	}

//	Time: O(n) and Space: O(1)
	private static int getMaxContainer2(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
			if (height[start] < height[end])
				start++;
			else
				end--;
		}
		return max;
	}
}
