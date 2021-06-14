package linkedlist.medium;

public class Node {

	int data;
	Node next;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
	}
	
	public void print() {
		Node current = this;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}