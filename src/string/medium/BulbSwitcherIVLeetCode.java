package string.medium;

public class BulbSwitcherIVLeetCode {

	public static void main(String[] args) {
		String target1 = "10111";
		String target2 = "101";
		String target3 = "00000";
		String target4 = "001011101";
		
		System.out.println(minFlips(target1));
		System.out.println(minFlips(target2));
		System.out.println(minFlips(target3));
		System.out.println(minFlips(target4));
	}

	static int minFlips(String target) {
		int minFlip = 0;
		char ch = '0';
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) != ch) {
				minFlip++;
				ch=target.charAt(i);
			}
		}
		return minFlip;
	}
}
