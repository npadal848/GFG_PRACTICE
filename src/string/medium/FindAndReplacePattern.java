package string.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {

	public static void main(String[] args) {
		String[] words = { "abc", "deq", "mee", "aqq", "akd", "ccc" };
		String pattern = "abb";

		String[] words2 = { "a", "b", "c" };
		String pattern2 = "a"; // Output: ["a","b","c"]

		patternMatching(words, pattern).forEach(word -> System.out.print(word + " "));
		System.out.println();
		patternMatching(words2, pattern2).forEach(word -> System.out.print(word + " "));
	}

	static List<String> patternMatching(String[] words, String pattern) {
		List<String> list = new ArrayList<String>();
		for (String word : words) {
			if (isMatched(word, pattern))
				list.add(word);
		}
		return list;
	}

	static boolean isMatched(String word, String pat) {
		int[] wPat = new int[26];
		int[] pPat = new int[26];
		for (int i = 0; i < pat.length(); i++) {
			if (wPat[word.charAt(i) - 'a'] != pPat[pat.charAt(i) - 'a'])
				return false;
			wPat[word.charAt(i) - 'a']++;
			pPat[pat.charAt(i) - 'a']++;
		}
		return true;
	}
}
