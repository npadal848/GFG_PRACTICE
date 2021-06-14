package linkedlist.medium;

public class RemoveKthNodeFromEndOfLL {

	public static void main(String[] args) {
		Node head = new Node(10);
		int k = 1;
		head = remove(head, k);
		System.out.println(head);

		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.print();
		head1 = remove(head1, 1);
		head1.print();

		System.out.println();
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.print();
		head2 = remove(head2, 2);
		head2.print();

		System.out.println();
		Node head3 = new Node(1);
		head3.next = new Node(2);
		head3.next.next = new Node(3);
		head3.next.next.next = new Node(4);
		head3.next.next.next.next = new Node(5);
		head3.print();
		head3 = remove(head3, 2);
		head3.print();

	}

	private static Node remove(Node head, int k) {
		if (head == null)
			return head;
		Node fast = head;
		Node slow = head;
		for (int i = 1; i < k; i++) {
			fast = fast.next;
		}
		Node prev = null;
		while (fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		if (slow == head)
			return slow.next;
		prev.next = slow.next;
		return head;
	}
}
