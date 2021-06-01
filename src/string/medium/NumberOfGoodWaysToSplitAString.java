package string.medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberOfGoodWaysToSplitAString {

	/*
	 * Output: 2 Explanation: There are 5 ways to split "aacaba" and 2 of them are
	 * good. ("a", "acaba") Left string and right string contains 1 and 3 different
	 * letters respectively. ("aa", "caba") Left string and right string contains 1
	 * and 3 different letters respectively. ("aac", "aba") Left string and right
	 * string contains 2 and 2 different letters respectively (good split).
	 * ("aaca","ba") Left string and right string contains 2 and 2 different letters
	 * respectively (good split). ("aacab", "a") Left string and right string
	 * contains 3 and 1 different letters respectively.
	 */
	public static void main(String[] args) {
		String s1 = "aacaba";
		String s2 = "abcd"; // Output: 1
		String s3 = "aaaaa"; // Output: 4
		String s4 = "acbadbaada"; // Output: 2

		System.out.println(noOfGoodWays1(s1));
		System.out.println(noOfGoodWays1(s2));
		System.out.println(noOfGoodWays1(s3));
		System.out.println(noOfGoodWays1(s4));
		System.out.println();
		System.out.println(noOfGoodWays2(s1));
		System.out.println(noOfGoodWays2(s2));
		System.out.println(noOfGoodWays2(s3));
		System.out.println(noOfGoodWays2(s4));
	}

//	Time: O(n^2) and Space: O(n)
	static int noOfGoodWays1(String s) {
		int count = 0;
		for (int i = 1; i < s.length(); i++) {
			Set<Character> set1 = s.substring(0, i).chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
			Set<Character> set2 = s.substring(i).chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
			if (set1.size() == set2.size())
				count++;
		}
		return count;
	}

//	Time: O(n) and Space: O(n)
	static int noOfGoodWays2(String s) {
		int n = s.length();
		int[] suffix = new int[s.length()];
		int[] preffix = new int[s.length()];
		Set<Character> preffixSet = new HashSet<>();
		Set<Character> suffixSet = new HashSet<>();
		int noOfGoodCut = 0;
		for (int i = 0; i < n; i++) {
			preffixSet.add(s.charAt(i));
			suffixSet.add(s.charAt(n - 1 - i));
			preffix[i] = preffixSet.size();
			suffix[n - 1 - i] = suffixSet.size();
		}

		for (int i = 0; i < n - 1; i++) {
			if (preffix[i] == suffix[i + 1])
				noOfGoodCut++;
		}
		return noOfGoodCut;
	}
}
