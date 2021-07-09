package stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class CrawlerLogFolder {

	public static void main(String[] args) {
		String[] logs1 = { "d1/", "d2/", "../", "d21/", "./" };
		String[] logs2 = { "./", "../", "./" };
		System.out.println(minOperations(logs1));
		System.out.println(minOperations(logs2));
	}

	public static int minOperations(String[] logs) {
		Deque<String> stack = new ArrayDeque<>();
		start: for (String log : logs) {
			if (log.equals(String.valueOf("./")))
				continue start;
			if (log.equals("../")) {
				if (stack.isEmpty())
					continue start;
				stack.pop();

			} else
				stack.push(log);
		}
		return stack.size();
	}
}
