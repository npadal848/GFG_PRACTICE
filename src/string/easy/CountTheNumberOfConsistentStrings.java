package string.easy;

import java.util.Arrays;

/*
 * You are given a string allowed consisting of distinct characters and an array of 
 * strings words. A string is consistent if all characters in the string appear in 
 * the string allowed.Return the number of consistent strings in the array words.
 */
public class CountTheNumberOfConsistentStrings {

	public static void main(String[] args) {
		String allowed1 = "ab";
		String[] words1 = { "ad", "bd", "aaab", "baa", "badab" }; // Output: 2

		String allowed2 = "abc";
		String[] words2 = { "a", "b", "c", "ab", "ac", "bc", "abc" }; // Output: 7

		String allowed3 = "cad";
		String[] words3 = { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" }; // Output: 4

		System.out.println(countConsistentStrings1(allowed1, words1));
		System.out.println(countConsistentStrings1(allowed2, words2));
		System.out.println(countConsistentStrings1(allowed3, words3));
		System.out.println();
		System.out.println(countConsistentStrings2(allowed1, words1));
		System.out.println(countConsistentStrings2(allowed2, words2));
		System.out.println(countConsistentStrings2(allowed3, words3));
		System.out.println();
		System.out.println(countConsistentStrings3(allowed1, words1));
		System.out.println(countConsistentStrings3(allowed2, words2));
		System.out.println(countConsistentStrings3(allowed3, words3));
	}

//	Time: O(words*char of word) and Space: O(1)
	static int countConsistentStrings1(String allowed, String[] words) {
		int count = 0;
		for (String word : words) {
			boolean flag = true;
			for (char ch : word.toCharArray()) {
				if (!allowed.contains(ch + "")) {
					flag = false;
					break;
				}
			}
			if (flag)
				count++;
		}
		return count;
	}

//	Time: O(words*char of word) and Space: O(1) :Improved solution
	static int countConsistentStrings2(String allowed, String[] words) {
		int count = 0;
		boolean[] map = new boolean[26];
		for (char ch : allowed.toCharArray()) {
			map[ch - 'a'] = true;
		}

		search: for (String word : words) {
			for (char ch : word.toCharArray()) {
				if (!map[ch - 'a'])
					continue search;
			}
			count++;
		}
		return count;
	}

//	Time: O(words*char of word) and Space: O(1)
	static int countConsistentStrings3(String allowed, String[] words) {
		return Arrays.stream(words)
				.mapToInt(word -> word.chars().allMatch(ch -> allowed.contains((char) ch + "")) ? 1 : 0).sum();
	}
}
