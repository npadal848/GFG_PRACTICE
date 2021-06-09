package hashing.easy;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {

	public static void main(String[] args) {
		String[] words1 = { "cat", "bt", "hat", "tree" };
		String chars1 = "atach"; // Output: 6

//		Explanation: 
//		The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

		String[] words2 = { "hello", "world", "leetcode" };
		String chars2 = "welldonehoneyr"; // Output: 10

		System.out.println(countCharacters(words1, chars1));
		System.out.println(countCharacters(words2, chars2));
	}

	private static int countCharacters(String[] words, String chars) {
		int sum = 0;
		int[] charsCount = getCharsCount(chars);
		for (String word : words) {
			if (isCharMatched(word, charsCount)) {
				sum += word.length();
			}
		}
		return sum;
	}

	private static boolean isCharMatched(String word, int[] charsCount) {
		int[] temp = Arrays.copyOf(charsCount, charsCount.length);
		for (char ch : word.toCharArray()) {
			temp[ch - 'a']--;
			if (temp[ch - 'a'] < 0)
				return false;
		}
		return true;
	}

	private static int[] getCharsCount(String chars) {
		int count[] = new int[26];
		for (char ch : chars.toCharArray()) {
			count[ch - 'a']++;
		}
		return count;
	}
}
