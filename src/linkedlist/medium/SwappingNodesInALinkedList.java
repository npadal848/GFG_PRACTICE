package linkedlist.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwappingNodesInALinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node head = new Node(-1);
		Node curr = head;
		while (n-- > 0) {
			curr.next = new Node(sc.nextInt());
			curr = curr.next;
		}
		int k = sc.nextInt();
		head = head.next;
//		Node head1 = head;
//		Node head2 = head;
//		head.print();
//		head = swap1(head, k);
//		head.print();
//		System.out.println();
//		head1.print();
//		head1 = swap2(head1, k);
//		head1.print();
//		System.out.println();
		head.print();
		head = swap3(head, k);
		head.print();
	}

//	Time: O(n) and Space: O(n) // Store node value to list and rebuild LinkedList
	private static Node swap1(Node head, int k) {
		if (head == null || head.next == null)
			return head;

		List<Integer> list = new ArrayList<>();
		Node curr = head;
		while (curr != null) {
			list.add(curr.data);
			curr = curr.next;
		}

		int temp = list.get(k - 1);
		list.set(k - 1, list.get(list.size() - k));
		list.set(list.size() - k, temp);

		head = new Node(-1);
		curr = head;
		for (int data : list) {
			curr.next = new Node(data);
			curr = curr.next;
		}
		return head.next;
	}

//	Time: O(n) and Space: O(1) // Get two kth nodes from start and end point and swap the value
	private static Node swap2(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		Node slow = head;
		Node fast = head;

		// Move fast up to kth node from starting
		for (int i = 1; i < k; i++) {
			fast = fast.next;
		}

		Node firstKthNode = fast;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		Node secondKthNode = slow;

		// Swap the data of Two kth nodes
		int temp = firstKthNode.data;
		firstKthNode.data = secondKthNode.data;
		secondKthNode.data = temp;

		return head;
	}

//	Time: O(n) and Space: O(1) // Get two kth nodes from start and end point and swap the value
	private static Node swap3(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		Node slow = head;
		Node fast = head;
		Node firstPrev = null;
		Node secondPrev = null;
		// Move fast up to kth node from starting
		for (int i = 1; i < k; i++) {
			firstPrev = fast;
			fast = fast.next;
		}

		Node firstKthNode = fast;
		while (fast.next != null) {
			secondPrev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		Node secondKthNode = slow;

		if (secondPrev == null || slow== fast) {
			Node prev = null;
			Node curr = head;
			head = head.next;
			curr.next = prev;
			head.next = curr;
		} else {
			Node secondNext = secondKthNode.next;
			Node firstNext = firstKthNode.next;
			firstPrev.next = secondKthNode;
			secondKthNode.next = firstNext;

			secondPrev.next = firstKthNode;
			firstKthNode.next = secondNext;
		}
		return head;
	}
}
