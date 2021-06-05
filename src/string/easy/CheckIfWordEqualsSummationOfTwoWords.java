package string.easy;

public class CheckIfWordEqualsSummationOfTwoWords {

	public static void main(String[] args) {
		String firstWord1 = "acb";
		String secondWord1 = "cba";
		String targetWord1 = "cdb"; // Output: true

		System.out.println(isSumEqual1(firstWord1, secondWord1, targetWord1));
		System.out.println(isSumEqual2(firstWord1, secondWord1, targetWord1));
	}

//	Time: theta(n) and Space: O(n)
	static boolean isSumEqual1(String firstWord, String secondWord, String targetWord) {
		StringBuilder firstSb = new StringBuilder();
		for (int i = 0; i < firstWord.length(); i++)
			firstSb.append(firstWord.charAt(i) - 'a');

		StringBuilder secondSb = new StringBuilder();
		for (int i = 0; i < secondWord.length(); i++)
			secondSb.append(secondWord.charAt(i) - 'a');

		StringBuilder targetSb = new StringBuilder();
		for (int i = 0; i < targetWord.length(); i++)
			targetSb.append(targetWord.charAt(i) - 'a');
		int firstNum = Integer.valueOf(firstSb.toString());
		int secondNum = Integer.valueOf(secondSb.toString());
		int targetNum = Integer.valueOf(targetSb.toString());

		return ((firstNum + secondNum) == targetNum);
	}

//	Time: theta(n) and Space: O(1)
	static boolean isSumEqual2(String firstWord, String secondWord, String targetWord) {
		return (getNumericValue(firstWord) + getNumericValue(secondWord) == getNumericValue(targetWord));
	}

	static int getNumericValue(String word) {
		int num = 0;
		for (int i = 0; i < word.length(); i++)
			num = num * 10 + (word.charAt(i) - 'a');
		return num;
	}
}
