package stack.medium;

import java.util.Stack;

public class ValidateStackSequence {

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };

		System.out.println(validateStackSequences(pushed, popped));

		int[] pushed2 = { 1, 2, 3, 4, 5 };
		int[] popped2 = { 4, 3, 5, 2 };
		System.out.println(validateStackSequences(pushed2, popped2));
	}

	private static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> pushStack = new Stack<>();
		int i = 0;
		for (int num : pushed) {
			pushStack.push(num);
			while (!pushStack.isEmpty() && i < popped.length && pushStack.peek() == popped[i]) {
				pushStack.pop();
				i++;
			}
		}
		return pushStack.isEmpty();
	}
}
