package linkedlist.medium;

public class ReverseALinkedList {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.next = new Node(20);
		root.next.next = new Node(30);
		root.next.next.next = new Node(40);
		root.next.next.next.next = new Node(50);

		Node head = reverse(root);
		head.print();
	}

	public static Node reverse(Node head) {
		if (head == null)
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
}
