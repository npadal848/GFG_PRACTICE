package string.medium;

import java.util.Scanner;

public class LongestPallindromicSubString {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();

			System.out.println(longestPallindrom1(str));
			System.out.println(longestPallindrom2(str));
		} catch (Exception e) {
		}
	}

//	Time: O(n^3) and Space: O(1)
	private static String longestPallindrom1(String str) {
		String res = String.valueOf(str.charAt(0));
		int n = str.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				String subStr = str.substring(i, j + 1);
				if (isPallindrom(subStr) && subStr.length() > res.length()) {
					res = subStr;
				}
			}
		}
		return res;
	}

//	Time: O(n^2) and Space: O(1)
	public static String longestPallindrom2(String s) {
		if (s == null)
			return null;
		if (s.length() <= 1)
			return s;
		String res = String.valueOf(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			String oddPallStr = getPallindromString(s, i, i);
			if (oddPallStr.length() > res.length())
				res = oddPallStr;
			String evenPallStr = getPallindromString(s, i, i + 1);
			if (evenPallStr.length() > res.length())
				res = evenPallStr;
		}
		return res;
	}

	private static String getPallindromString(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}

	private static boolean isPallindrom(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
