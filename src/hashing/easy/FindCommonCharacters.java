package hashing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindCommonCharacters {

	public static void main(String[] args) {

		String[] words1 = { "bella", "label", "roller" }; // Output: ["e","l","l"]
		String[] words2 = { "cool", "lock", "cook" }; // Output: ["c","o"]
		
		getAllCommmonChars(words1).forEach(ch->System.out.print(ch+" "));
		System.out.println();
		getAllCommmonChars(words2).forEach(ch->System.out.print(ch+" "));
	}

	private static List<String> getAllCommmonChars(String[] words) {
		List<String> res = new ArrayList<String>();
		int allStrFreq[] = new int[26];
		Arrays.fill(allStrFreq, Integer.MAX_VALUE);

		for (String word : words) {
			int currStrFreq[] = new int[26];
			word.chars().forEach(ch -> ++currStrFreq[ch - 'a']);

//			for (char i = 0; i < 26; i++) {
//				allStrFreq[i] = Math.min(allStrFreq[i], currStrFreq[i]);
//			}
//			Same logic as above in Java 8 feature Stream API
			IntStream.range(0, 26).forEach(i -> allStrFreq[i] = Math.min(allStrFreq[i], currStrFreq[i]));
		}

		for (char ch = 'a'; ch <= 'z'; ch++) {
			while (allStrFreq[ch - 'a']-- > 0)
				res.add("" + ch);
		}
		return res;
	}
}
