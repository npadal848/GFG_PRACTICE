package hashing.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKUniqueCharacters {
	public static void main(String[] args) {
		String s1 = "aabacbebebe"; // Output: 7 - cbebebe - longest k unique character
		String s2 = "aabacdebebe"; // Output: 6 - debebe - longest k unique character
		int k = 3;
		System.out.println(longestSubString1(s1, k));
		System.out.println(longestSubString1(s2, k));
		System.out.println();
		System.out.println(longestSubString2(s1, k));
		System.out.println(longestSubString2(s2, k));
	}

//	Time: O(n^2) and Space: O(n)
	static int longestSubString1(String s, int k) {
		int n = s.length();
		int max = -1;
		for (int i = 0; i < n; i++) {
			if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
				Set<Character> set = new HashSet<>();
				set.add(s.charAt(i));
				for (int j = i + 1; j < n; j++) {
					set.add(s.charAt(j));
					if (set.size() == k) {
						max = Math.max(max, j - i + 1);
					} else if (set.size() == k) {
						break;
					}
				}
			}
		}
		return max;
	}

//	Time: O(n) and Space: O(1)
	static int longestSubString2(String s, int k) {
		int max = 0;

		int i = 0;
		int j = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() < k) {
				j++;
				continue;
			}

			if (map.size() == k) {
				max = Math.max(max, j - i + 1);
			} else {
				while (map.size() > k) {
					ch = s.charAt(i);
					map.put(ch, map.get(ch) - 1);
					if (map.get(ch) == 0)
						map.remove(ch);
					i++;
				}
			}
			j++;
		}

		return max;
	}
}
