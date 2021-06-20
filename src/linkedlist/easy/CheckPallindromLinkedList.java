package linkedlist.easy;

import java.util.Scanner;

public class CheckPallindromLinkedList {

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
		System.out.println(isPalindrome(head));
	}

	static boolean isPalindrome(Node head) {
		if (head == null || head.next == null)
			return true;
		// Your code here
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node fisrtHalf = head;

		// reverse second half
		Node prev = null;
		Node curr = slow;
		while (curr.next != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		curr.next = prev;
		Node secondHalf = curr;
		while (secondHalf != null) {
			if (fisrtHalf.data != secondHalf.data)
				return false;
			fisrtHalf = fisrtHalf.next;
			secondHalf = secondHalf.next;
		}
		return true;
	}
}
