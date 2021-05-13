package sorting.easy;

/*
 * LeetCode Sorting Problem
 * https://leetcode.com/problems/increasing-decreasing-string/
 * 
 * 	1. Pick the smallest character from s and append it to the result.
	2. Pick the smallest character from s which is greater than the last appended character to the result and append it.
	3. Repeat step 2 until you cannot pick more characters.
	4. Pick the largest character from s and append it to the result.
	5. Pick the largest character from s which is smaller than the last appended character to the result and append it.
	6. Repeat step 5 until you cannot pick more characters.
	7. Repeat the steps from 1 to 6 until you pick all characters from s.
 */
public class IncreasingDecreasingString {

	public static void main(String[] args) {
		String str = "aaaabbbbcccc";

		System.out.println(reorder1(str));
	}

	static String reorder1(String str) {

		StringBuilder ans = new StringBuilder();
		int[] count = new int[26];
		for (char c : str.toCharArray())
			++count[c - 'a'];
		while (ans.length() < str.length()) {
			add(count, ans, true);
			add(count, ans, false);
		}
		return ans.toString();
	}

	private static void add(int[] cnt, StringBuilder ans, boolean asc) {
		for (int i = 0; i < 26; ++i) {
			int j = asc ? i : 25 - i;
			if (cnt[j]-- > 0)
				ans.append((char) (j + 'a'));
		}
	}
}
