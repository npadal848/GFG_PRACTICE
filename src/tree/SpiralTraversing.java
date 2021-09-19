package tree;

import java.util.Stack;

public class SpiralTraversing {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		Node rootLeft = root.left;
		rootLeft.left = new Node(4);
		rootLeft.right = new Node(5);

		Node rootRight = root.right;
		rootRight.left = new Node(6);
		rootRight.right = new Node(7);

		Node left = rootLeft.left;
		left.left = new Node(8);
		left.right = new Node(9);

		Node six = rootRight.left;
		six.left = new Node(10);
		six.right = new Node(11);

		spiralTraverse(root);
	}

	public static void spiralTraverse(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.add(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node curr = s1.pop();
				System.out.print(curr.data + " ");
				if (curr.left != null) {
					s2.add(curr.left);
				}
				if (curr.right != null) {
					s2.add(curr.right);
				}
			}
			System.out.println();
			while (!s2.isEmpty()) {
				Node curr = s2.pop();
				System.out.print(curr.data + " ");
				if (curr.right != null) {
					s1.add(curr.right);
				}
				if (curr.left != null) {
					s1.add(curr.left);
				}
			}
			System.out.println();
		}
	}
}
