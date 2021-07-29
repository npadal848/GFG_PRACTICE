package bit_manipulation;

import java.util.Arrays;
import java.util.Scanner;

public class CountSetBit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Arrays.stream(countBits(num)).forEach(System.out::println);;
	}

	public static int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}
}
