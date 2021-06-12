package math.easy;

import java.util.Scanner;

public class CheckPallindromNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(isPalindrome1(num));
		System.out.println(isPalindrome2(num));
	}

//	Time: (n) and Space: O(n)
	private static boolean isPalindrome1(int x) {
		String num = String.valueOf(x);
		int start = 0;
		int end = num.length() - 1;
		while (start < end) {
			if (num.charAt(start) != num.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

//	Time: (n) and Space: O(1)
	private static boolean isPalindrome2(int x) {
		int temp = x;
		int rev = 0;
		while (temp > 0) {
			int rem = temp % 10;
			rev = rev * 10 + rem;
			temp = temp / 10;
		}
		return (rev == x);
	}
}
