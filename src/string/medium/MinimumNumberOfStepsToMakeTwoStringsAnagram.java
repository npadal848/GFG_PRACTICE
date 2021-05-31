package string.medium;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

	public static void main(String[] args) {
		String s1="bab";
		String t1="aba";
		
		String s2="leetcode";
		String t2="practice";
		
		System.out.println(minStepToMakeAnagram(s1, t1));
		System.out.println(minStepToMakeAnagram(s2, t2));
	}

//	
	static int minStepToMakeAnagram(String s, String t) {
		String str = s;
		for (int i = 0; i < s.length(); i++) {
			if (t.indexOf(str.charAt(i)) >= 0) {
				t = t.replaceFirst(str.charAt(i) + "", "");
			}
		}
		return (s.length() == t.length()) ? 0 : t.length();
	}
}
