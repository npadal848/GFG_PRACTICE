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

		System.out.println(shiftingLetters1(s1, shifts1));
		System.out.println(shiftingLetters1(s2, shifts2));
		System.out.println();
		System.out.println(shiftingLetters2(s1, shifts1));
		System.out.println(shiftingLetters2(s2, shifts2));
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
			shift[i] = shift[i] + shift[i + 1];
		}

		for (int i = 0; i < s.length(); i++) {
			sb.setCharAt(i, (char) ((sb.charAt(i) - 'a' + shift[i]) % 26 + 'a'));
		}
		return sb.toString();
	}
}
