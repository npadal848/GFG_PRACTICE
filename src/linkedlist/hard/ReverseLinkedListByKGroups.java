package linkedlist.hard;

import java.util.Scanner;

public class ReverseLinkedListByKGroups {

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
		head.print();
		head = reverse(head, k);
		head.print();
	}

	private static Node reverse(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		int nodeCount = 0;
		Node curr = head;
		while (curr != null) {
			nodeCount++;
			curr = curr.next;
		}
		int possibleGroup = nodeCount / k;
		int groupCount = 0;
		Node prevGroupFirstNode = null;
		curr = head;
		boolean isFirstPass = true;
		while (curr != null) {
			Node currGroupfirstNode = curr;
			Node prev = null;
			int count = 0;

			while (groupCount < possibleGroup && curr != null && count < k) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if (isFirstPass) {
				head = prev;
				isFirstPass = false;
			} else if (groupCount >= possibleGroup) {
				prevGroupFirstNode.next = curr;
				break;
			} else
				prevGroupFirstNode.next = prev;
			prevGroupFirstNode = currGroupfirstNode;
			groupCount++;
		}
		return head;
	}
}
