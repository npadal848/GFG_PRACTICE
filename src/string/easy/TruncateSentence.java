package string.easy;

public class TruncateSentence {

	public static void main(String[] args) {
		String s1 = "Hello how are you Contestant";
		int k1 = 4; // Output: "Hello how are you"

		String s2 = "What is the solution to this problem";
		int k2 = 4; // Output: "What is the solution"

		System.out.println(truncate1(s1, k1));
		System.out.println(truncate1(s2, k2));
		System.out.println();
		System.out.println(truncate2(s1, k1));
		System.out.println(truncate2(s2, k2));
	}

//	Time: O(n) and Space: O(n)
	static String truncate1(String s, int k) {
		String[] result = new String[k];
		String[] words = s.split(" "); // take O(n) to split
		for (int i = 0; i < k; i++) {
			result[i] = words[i];
		}
		return String.join(" ", result);
	}

//	Time: O(n) and Space: O(1)
	static String truncate2(String s, int k) {
		int i = 0;
		int spaceCount = 0;
		while (i < s.length() && spaceCount < k) {
			if (s.charAt(i) == ' ')
				spaceCount++;
			i++;
		}
		return spaceCount == k ? s.substring(0, i - 1) : s;
	}
}
