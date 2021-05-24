package string.easy;

import java.util.Arrays;

public class CheckIfTheSentenceIsPangram {

	public static void main(String[] args) {
		String str1="thequickbrownfoxjumpsoverthelazydog";
		String str2="leetcode";
		
		System.out.println(checkPangram(str1));
		System.out.println(checkPangram(str2));
	}

	static boolean checkPangram(String str) {
		int[] count = new int[26];
		Arrays.fill(count, -1);
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == -1)
				return false;
		}
		return true;
	}
}
