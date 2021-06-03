package string.easy;

public class JewelsAndStones {

	public static void main(String[] args) {
		String jewels1 = "aA";
		String stones1 = "aAAbbbb"; // Output: 3

		String jewels2 = "z";
		String stones2 = "ZZ"; // Output: 0

		System.out.println(numJewelsInStones1(jewels1, stones1));
		System.err.println(numJewelsInStones1(jewels2, stones2));
		System.out.println();
		System.out.println(numJewelsInStones2(jewels1, stones1));
		System.err.println(numJewelsInStones2(jewels2, stones2));
	}

//	Time: Theta(s+j) and Space: O(1)
	static int numJewelsInStones1(String jewels, String stones) {
		int count = 0;
		for (char c : stones.toCharArray()) {
			if (jewels.indexOf(c) >= 0)
				count++;
		}
		return count;
	}

//	Time: Theta(s) and Space: O(1)
	static int numJewelsInStones2(String jewels, String stones) {
		int res = 0;
		int[] count = new int[58];
		for (int i = 0; i < stones.length(); i++)
			count[stones.charAt(i) - 'A']++;
		for (int i = 0; i < jewels.length(); i++)
			res += count[jewels.charAt(i) - 'A'];
		return res;
	}
}
