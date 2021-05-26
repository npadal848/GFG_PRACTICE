package string.medium;

public class ShiftingLetters {

	/*
	 * Example: String s1 = "abc"; int[] shifts = { 3, 5, 9 }; Output: "rpl"
	 * Explanation: We start with "abc". After shifting the first 1 letters of S by
	 * 3, we have "dbc". After shifting the first 2 letters of S by 5, we have
	 * "igc". After shifting the first 3 letters of S by 9, we have "rpl", the
	 * answer.
	 */

	public static void main(String[] args) {
		String s1 = "abc";
		int[] shifts1 = { 3, 5, 9 }; // Output: rpl

		String s2 = "bad";
		int[] shifts2 = { 10, 20, 30 }; // Output: jyh

		String s3 = "mkgfzkkuxownxvfvxasy"; // Output: wqqwlcjnkphhsyvrkdod
		int[] shifts3 = { 505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950,
				81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912,
				116899933, 983296461, 536563513 };

		System.out.println(shiftingLetters1(s1, shifts1));
		System.out.println(shiftingLetters1(s2, shifts2));
		System.out.println(shiftingLetters1(s3, shifts3));
		System.out.println();
		System.out.println(shiftingLetters2(s1, shifts1));
		System.out.println(shiftingLetters2(s2, shifts2));
		System.out.println(shiftingLetters2(s3, shifts3));
		System.out.println();
//		System.out.println(shiftingLetters3(s1, shifts1));
//		System.out.println(shiftingLetters3(s2, shifts2));
		System.out.println(shiftingLetters3(s3, shifts3));
	}

//	Time: O(n^2) and Space: O(n)
	static String shiftingLetters1(String s, int[] shift) {
		char[] ch = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				ch[j] = (char) ((ch[j] - 'a' + shift[i]) % 26 + 'a');
			}
		}
		return String.valueOf(ch);
	}

//	Time: O(n) and Space: O(n)
	static String shiftingLetters2(String s, int[] shift) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = shift.length - 2; i >= 0; i--) {
			shift[i] = (shift[i] + shift[i + 1]) % 26;
		}

		for (int i = 0; i < s.length(); i++) {
			sb.setCharAt(i, (char) ((s.charAt(i) - 'a' + shift[i]) % 26 + 'a'));
		}
		return sb.toString();
	}

//	Time: O(n) and Space: O(n) : improved solution with one iteration
	static String shiftingLetters3(String s, int[] shifts) {
		int shift = 0;
        char[] str = s.toCharArray();
        
        for( int i  = str.length-1; i >= 0; i-- ) {
            shift = (shift + shifts[i])%26;
            str[i] = (char)((str[i] - 'a' + shift) %26 + 'a');
        }
        
        return new String(str);
	}
}
