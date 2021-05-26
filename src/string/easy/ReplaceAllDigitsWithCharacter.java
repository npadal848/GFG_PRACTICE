package string.easy;

public class ReplaceAllDigitsWithCharacter {

	public static void main(String[] args) {
		String s1 = "a1c1e1"; // Output: "abcdef"
		String s2 = "a1b2c3d4e"; // Output: "abbdcfdhe"
		String s3 = "v0g6s4d"; // Output:""vvgmswd""

		System.out.println(replaceDigits1(s1));
		System.out.println(replaceDigits1(s2));
		System.out.println(replaceDigits1(s3));
		System.out.println();
		System.out.println(replaceDigits2(s1));
		System.out.println(replaceDigits2(s2));
		System.out.println(replaceDigits2(s3));
	}

//	Time: O(n) and Space: O(n)
	static String replaceDigits1(String s) {
		StringBuilder sb = new StringBuilder();
		search: for (int i = 0; i < s.length(); i++) {
			if (i % 2 != 0) {
				int digit=Character.getNumericValue(s.charAt(i));
				sb.append((char)(s.charAt(i-1)+digit));
				continue search;
			}
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
//	Time: O(n) and Space: O(n) -- Improved solution
	static String replaceDigits2(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < s.length(); i+=2) {
			sb.setCharAt(i, (char)(s.charAt(i-1)+Character.getNumericValue(s.charAt(i))));
		}
		return sb.toString();
	}
}
