package linkedlist.easy;

import java.util.Scanner;

public class ConvertBinaryNumInALLToInteger {

	public static void main(String[] args) {
		Node head=new Node(1);
		head.next=new Node(1);
		head.next.next=new Node(0);
		
		System.out.println(convertToInteger1(head));
		System.out.println(convertToInteger2(head));
	}

	private static int convertToInteger1(Node head) {
		StringBuilder sb = new StringBuilder();
		Node curr = head;
		while (curr != null) {
			sb.append(curr.data);
			curr = curr.next;
		}
		return convertToDecimal(sb.toString());
	}

	private static int convertToDecimal(String num) {
		int res = 0;
		int base = 1;
		int len = num.length();
		for (int i = len - 1; i >= 0; i--) {
			if (num.charAt(i) == '1')
				res += base;
			base = base * 2;
		}
		return res;
	}

	private static int convertToInteger2(Node head) {
		int res = 0;

		while (head != null) {
			res = res * 2 + head.data;
			head = head.next;
		}
		return res;
	}
}
