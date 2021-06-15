package linkedlist.medium;

import java.util.Scanner;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node head = new Node(-1);
		Node curr = head;
		while (n-- > 0) {
			curr.next = new Node(sc.nextInt());
			curr = curr.next;
		}
		head = head.next;
		head.print();
		head = oddEvenList(head);
		head.print();
	}

	private static Node oddEvenList(Node head) {
		if (head == null || head.next == null)
			return head;
		Node oddStart = null;
		Node oddEnd = null;
		Node evenStart = null;
		Node evenEnd = null;
		Node curr = head;

		while (curr != null) {
			int data = curr.data;
			if ((data & 1) == 1) {
				if (oddStart == null) {
					oddStart = curr;
					oddEnd = curr;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			} else {
				if (evenStart == null) {
					evenStart = curr;
					evenEnd = curr;
				} else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			}
			curr = curr.next;
		}
		if ((head.data & 1) == 0) {
			evenEnd.next = oddStart;
			oddEnd.next = null;
			return evenStart;
		} else {
			oddEnd.next = evenStart;
			evenEnd.next = null;
			return oddStart;
		}
	}
}
