package linkedlist.medium;

import java.util.Scanner;

public class AddTwoNumbers {

//	https://leetcode.com/problems/add-two-numbers/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		Node head1 = new Node(-1);
		Node curr = head1;
		while (n1-- > 0) {
			curr.next = new Node(sc.nextInt());
			curr = curr.next;
		}
		head1 = head1.next;
		int n2 = sc.nextInt();
		Node head2 = new Node(-1);
		curr = head2;
		while (n2-- > 0) {
			curr.next = new Node(sc.nextInt());
			curr = curr.next;
		}
		head2 = head2.next;
		head1.print();
		head2.print();
		Node head = addTwoNum(head1, head2);
		head.print();
	}

//	Time: O(n) and Space: O(n) // It does not work for input like below
//	[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
//	[5,6,4]
	private static Node add(Node head1, Node head2) {
		long num1 = getNum(reverse(head1));
		long num2 = getNum(reverse(head2));
		long sum = num1 + num2;
		if (sum == 0)
			return new Node((int) sum);
		Node head = new Node(-1);
		Node curr = head;
		while (sum > 0) {
			int lastDigit = (int) (sum % 10);
			curr.next = new Node(lastDigit);
			curr = curr.next;
			sum = sum / 10;
		}
		return head.next;
	}

	private static long getNum(Node head) {
		Node curr = head;
		long num = 0;
		while (curr != null) {
			num = num * 10 + curr.data;
			curr = curr.next;
		}
		return num;
	}

	private static Node reverse(Node head) {
		if (head.next == null)
			return head;
		Node curr = head;
		Node prev = null;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static Node addTwoNum(Node head1, Node head2) {
		Node tempHead = new Node(-1);
		Node curr = tempHead;
		int carry = 0;

		while (head1 != null || head2 != null || carry != 0) {
			int sum = carry;
			if (head1 != null) {
				sum += head1.data;
				head1 = head1.next;
			}
			if (head2 != null) {
				sum += head2.data;
				head2 = head2.next;
			}
			curr.next = new Node(sum % 10);
			curr = curr.next;
			carry = sum / 10;
		}
		return tempHead.next;
	}
}
