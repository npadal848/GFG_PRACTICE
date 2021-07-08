package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjecentDuplicateFromStringII {

	public static void main(String[] args) {
		String s1 = "abcd";
		int k1 = 2; // Output: "abcd"

		String s2 = "deeedbbcccbdaa";
		int k2 = 3; // Output: "aa"

		String s3 = "pbbcggttciiippooaais";
		int k3 = 2; // Output: "ps"

		String s4 = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
		int k4 = 4;

		System.out.println(removeDuplicates(s1, k1));
		System.out.println(removeDuplicates(s2, k2));
		System.out.println(removeDuplicates(s3, k3));
		System.out.println(removeDuplicates(s4, k4));
	}

	public static String removeDuplicates(String s, int k) {
		Deque<Pair> stack = new ArrayDeque<>();
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty() || stack.peek().ch != ch)
				stack.push(new Pair(ch, 1));
			else {
				int count = stack.pop().count + 1;
				if (count != k)
					stack.push(new Pair(ch, count));
			}
		}
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()) {
			int count = stack.peek().count;
			char ch = stack.pop().ch;
			while(count-->0)
				builder.append(ch);
		}
		return String.valueOf(builder.reverse());
	}

}

class Pair {
	char ch;
	int count;

	public Pair(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}
}
