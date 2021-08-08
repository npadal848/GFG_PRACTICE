package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		Node leftSubTree1 = root.left;
		leftSubTree1.left = new Node(4);
		leftSubTree1.right = new Node(5);
		Node rightSubTree1 = root.right;
		rightSubTree1.right = new Node(7);
		
		print(connect1(root));
		
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		Node leftSubTree11 = root1.left;
		leftSubTree11.left = new Node(4);
		Node rightSubTree11 = root1.right;
		rightSubTree11.right = new Node(5);
		Node rightSubTree2 = rightSubTree11.right;
		rightSubTree2.left = new Node(6);
		rightSubTree2.right = new Node(7);
		System.out.println();
		print(connect2(root1));
	}

//	Time: O(n) and Space: O(n)
	public static Node connect1(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			Node dummy = new Node(0);
			while (size-- > 0) {
				Node curr = q.poll();
				dummy.next = curr;
				dummy = dummy.next;

				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
		}

		return root;
	}

//	Time: O(n) and Space: O(1)
	public static Node connect2(Node root) {
		Node tempHead = root;
		while (tempHead != null) {
			Node levelHead = new Node(0);
			Node levelNode = levelHead;
			while (tempHead != null) {
				if (tempHead.left != null) {
					levelNode.next = tempHead.left;
					levelNode = levelNode.next;
				}
				if (tempHead.right != null) {
					levelNode.next = tempHead.right;
					levelNode = levelNode.next;
				}
				tempHead = tempHead.next;
			}
			tempHead = levelHead.next;
		}
		return root;
	}

	private static void print(Node root) {
		Node temp = root;
		while (temp != null) {
			Node nextLevelHead = new Node(0);
			Node node = nextLevelHead;
			while (temp != null) {
				System.out.print(temp.data + ",");
				if (temp.left != null) {
					node.next = temp.left;
					node = node.next;
				}
				if (temp.right != null) {
					node.next = temp.right;
					node = node.next;
				}
				temp = temp.next;
			}
			temp = nextLevelHead.next;
			System.out.print("#" + ",");
		}
	}
}
