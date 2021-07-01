package string.medium;

public class CustomSortString {

	public static void main(String[] args) {
		String order1 = "cba";
		String str1 = "abcd"; // Output: cbad
		
		String order2 = "cba";
		String str2 = "abcdabcdefga"; // Output: ccbbaaaddefg
		
		String order3 = "cbafg";
		String str3 = "abcd";  // Output: cbad
		
		System.out.println(customSortString(order1, str1));
		System.out.println(customSortString(order2, str2));
		System.out.println(customSortString(order3, str3));
	}

	static String customSortString(String order, String str) {
		StringBuilder res = new StringBuilder();
		int[] count = new int[26];
        for (char ch: str.toCharArray()) {
            count[ch-'a']++;
		}
        
        for (char ch: order.toCharArray()) {
            while(count[ch-'a']-->0)
                res.append(ch);
        }
        
        for (char ch: str.toCharArray()) {
            while(count[ch-'a']-->0)
                res.append(ch);
        }
		return String.valueOf(res);
	}
}
