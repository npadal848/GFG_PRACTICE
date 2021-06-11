package math.easy;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println(convertToDecimal1(num));
		System.out.println(convertToDecimal2(num));
		System.out.println(convertToDecimal3(num));
		
		sc.close();
	}

	private static int convertToDecimal1(int num) {
		int res = 0;
		int base = 1; // value to 1, i.e 2^0

		while (num > 0) {
			int lastDigit = num % 10;
			num = num / 10;
			if (lastDigit == 1)
				res += base;
			base = base * 2;
		}
		return res;
	}
	
	private static int convertToDecimal2(int num) {
		return Integer.parseInt(String.valueOf(num), 2);
	}
	
	static int convertToDecimal3(int n)
    {
        String num = String.valueOf(n);
        int dec_value = 0;
 
        // Initializing base value to 1,
        // i.e 2^0
        int base = 1;
 
        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }
 
        return dec_value;
    }

}
