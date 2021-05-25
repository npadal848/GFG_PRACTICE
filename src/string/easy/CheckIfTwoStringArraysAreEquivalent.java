package string.easy;

public class CheckIfTwoStringArraysAreEquivalent {

	public static void main(String[] args) {
		String[] word1 = { "ab", "c" };
		String[] word2 = { "a", "bc" };

		String[] word3 = {"a", "cb"};
		String[] word4 = {"ab", "c"};
		
		String[] word5  = {"abc", "d", "defg"};
		String[] word6 = {"abcddefg"};
				
//		System.out.println(arrayStringsAreEqual(word1, word2));
//		System.out.println(arrayStringsAreEqual(word3, word4));
		System.out.println(arrayStringsAreEqual(word5, word6));
	}

	static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		return String.join("", word1).equals(String.join("", word2));
	}
}
