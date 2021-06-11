package hashing.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvaluteTheBracketPairOfString {

	public static void main(String[] args) {
		String s1 = "(name)is(age)yearsold";
		List<List<String>> knowledge1 = new ArrayList<>();
		knowledge1.add(Arrays.asList("name", "bob"));
		knowledge1.add(Arrays.asList("age", "two")); // Output: "bobistwoyearsold"
//		Explanation:
//			The key "name" has a value of "bob", so replace "(name)" with "bob".
//			The key "age" has a value of "two", so replace "(age)" with "two".

		String s2 = "hi(name)";
		List<List<String>> knowledge2 = new ArrayList<>();
		knowledge2.add(Arrays.asList("a", "b")); // Output: "hi?"
//		Explanation: As you do not know the value of the key "name", replace "(name)" with "?".

		System.out.println(evaluate1(s1, knowledge1));
		System.out.println(evaluate1(s2, knowledge2));
		System.out.println();
		System.out.println(evaluate2(s1, knowledge1));
		System.out.println(evaluate2(s2, knowledge2));
	}

	private static String evaluate1(String s, List<List<String>> knowledge) {
		Map<String, String> map = new HashMap<>();
		StringBuilder key = new StringBuilder();
		boolean bracketFound = false;
		for (List<String> list : knowledge) {
			map.put(list.get(0), list.get(1));
		}

		for (char ch : s.toCharArray()) {
			if (ch == '(')
				bracketFound = true;
			else if (ch == ')') {
				String replaceStr = "(" + key.toString() + ")";
				if (map.containsKey(key.toString())) {
					s = s.replace(replaceStr, map.get(key.toString()));
				} else {
					s = s.replace(replaceStr, "?");
				}
				key = new StringBuilder();
				bracketFound = false;
			} else if (bracketFound) {
				key.append(ch);
			}
		}
		return s;
	}

//	Improved solution
	private static String evaluate2(String s, List<List<String>> knowledge) {
//		Map<String, String> map = knowledge.stream().collect(Collectors.toMap(list -> list.get(0), list -> list.get(1)));

		Map<String, String> map = new HashMap<>();
		for (List<String> list : knowledge) {
			map.put(list.get(0), list.get(1));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				int j = s.indexOf(")", i);
				sb.append(map.getOrDefault(s.substring(i + 1, j), "?"));
				i = j;
			} else
				sb.append(ch);
		}
		return sb.toString();
	}
}
