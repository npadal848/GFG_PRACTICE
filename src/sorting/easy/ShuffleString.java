package sorting.easy;

import java.util.TreeMap;
import java.util.stream.IntStream;

public class ShuffleString {

	public static void main(String[] args) {
		String s = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };

		System.out.println(suffleString1(s, indices));
		System.out.println(suffleString2(s, indices));
	}

	static String suffleString1(String s, int[] indices) {
		TreeMap<Integer, Character> map = new TreeMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(indices[i], s.charAt(i));
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			builder.append(map.get(i));
		}
		return builder.toString();
	}

	static String suffleString2(String s, int[] indices) {
		char[] charArr = new char[s.length()];
		IntStream.range(0, indices.length).forEach(i -> charArr[indices[i]] = s.charAt(i));
		return new String(charArr);
	}
}
