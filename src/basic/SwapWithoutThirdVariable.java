
package basic;

public class SwapWithoutThirdVariable {

	public static void main(String[] args) {
		int a = 10;
		int b = 30;

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println(a);
		System.out.println(b);
	}
}
