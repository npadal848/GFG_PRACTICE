package linkedlist.medium;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedLLII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node tempHead = new Node(-1);
		Node curr = tempHead;
		while (n-- > 0) {
			curr.next = new Node(sc.nextInt());
			curr=curr.next;
		}
		Node head = tempHead.next;
		head.print();
		head = remove(head);
		head.print();
	}

	private static Node remove(Node head) {
		Node prev = null;
		Node curr = head;

		while (curr != null && curr.next != null) {
			if (curr.data != curr.next.data) {
				prev = curr;
				curr = curr.next;
			} else {
				while (curr.next != null && curr.data == curr.next.data)
					curr = curr.next;
				if (prev != null)
					prev.next = curr.next;
				else
					head = curr.next;
				curr = curr.next;
			}
		}
		return head;
	}
}
