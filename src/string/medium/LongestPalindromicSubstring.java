package string.medium;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "babad"; // Output: "bab" Note: "aba" is also a valid answer.
		System.out.println(longestPallindrom(s));
		System.out.println();
		
		s = "cbbd"; // Output: "bb"
		System.out.println(longestPallindrom(s));
		System.out.println();
		
		s = "a"; // Output: "a"
		System.out.println(longestPallindrom(s));
		System.out.println();

		s = "ac";  // Output: "a"
		System.out.println(longestPallindrom(s));		
	}

	public static String longestPallindrom(String str) {
		int n = str.length();
		if (n < 2)
			return str;
		if (n == 2)
			str.charAt(0);
		String res = "";
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				String currStr = str.substring(i, j + 1);
				if (isPallindrom(currStr) && currStr.length() > maxLength) {
					maxLength = currStr.length();
					res = currStr;
				}
			}
		}

		return res;
	}

	private static boolean isPallindrom(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
