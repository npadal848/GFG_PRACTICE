package string.easy;

public class DetermineIfStringHalvesAreAlike {

	public static void main(String[] args) {
		String s1 = "book"; // Output: true
		String s2 = "textbook"; // Output: false

		System.out.println(halvesAreAlike1(s1));
		System.out.println(halvesAreAlike2(s2));
	}

//	Time: O(n) and Space: O(1)
	static boolean halvesAreAlike1(String s) {
		int halves = s.length() / 2;
		String s1 = s.substring(0, halves);
		String s2 = s.substring(halves, s.length());
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if (c1 == 'A' || c1 == 'E' || c1 == 'I' || c1 == 'O' || c1 == 'U' || c1 == 'a' || c1 == 'e' || c1 == 'i'
					|| c1 == 'o' || c1 == 'u')
				count1++;
			if (c2 == 'A' || c2 == 'E' || c2 == 'I' || c2 == 'O' || c2 == 'U' || c2 == 'a' || c2 == 'e' || c2 == 'i'
					|| c2 == 'o' || c2 == 'u')
				count2++;
		}
		return (count1 == count2);
	}

//	Time: O(n) and Space: O(1) Improved Solution
	static boolean halvesAreAlike2(String s) {
		int mid = s.length() / 2;
		String vowels = "AEIOUaeiou";
		int count = 0;
		for (int i = 0, j = mid; i < mid && j < s.length(); i++, j++) {
			if (vowels.indexOf(s.charAt(i)) >= 0)
				count++;
			if (vowels.indexOf(s.charAt(j)) >= 0)
				count--;
		}
		return (count == 0);
	}
}
