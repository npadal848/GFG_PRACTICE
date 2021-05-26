package string.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingTheSentence {

	public static void main(String[] args) {
		String s1 = "is2 sentence4 This1 a3"; // Output: "This is a sentence"
		String s2 = "Myself2 Me1 I4 and3"; // Output: "Me Myself and I"

		System.out.println(sortSentence1(s1));
		System.out.println(sortSentence1(s2));
		System.out.println();
		System.out.println(sortSentence2(s1));
		System.out.println(sortSentence2(s2));
	}

	static String sortSentence1(String s) {
		String[] sentence = s.split(" ");
		String[] str = new String[sentence.length];
		for (String word : sentence) {
			int index = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
			String removeDigit = word.substring(0, word.length() - 1);
			str[index] = removeDigit;
		}
		return String.join(" ", str);
	}

	static String sortSentence2(String s) {
		return Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(word -> word.charAt(word.length() - 1)))
				.map(word -> word.substring(0, word.length() - 1)).collect(Collectors.joining(" "));
	}
}
