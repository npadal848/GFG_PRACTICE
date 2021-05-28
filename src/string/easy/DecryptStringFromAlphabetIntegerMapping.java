package string.easy;

public class DecryptStringFromAlphabetIntegerMapping {

	public static void main(String[] args) {
		// Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
		String s1 = "10#11#12"; // Output: "jkab"

		String s2 = "1326#"; // Output: "acz"

		String s3 = "25#"; // Output: "y"

		String s4 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"; 
		// Output: abcdefghijklmnopqrstuvwxyz

		System.out.println(decrypt(s1));
		System.out.println(decrypt(s2));
		System.out.println(decrypt(s3));
		System.out.println(decrypt(s4));
	}

	static String decrypt(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n;) {
			if (i + 2 < n && s.charAt(i + 2) == '#') {
				int dig = Integer.valueOf(s.substring(i, i + 2)) - 1;
				sb.append((char) (dig + 'a'));
				i += 3;
			} else {
				sb.append((char) (Character.getNumericValue(s.charAt(i)) - 1 + 'a'));
				i++;
			}
		}
		return sb.toString();
	}
}
