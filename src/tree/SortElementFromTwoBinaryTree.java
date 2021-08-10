package tree;

import java.util.ArrayList;
import java.util.List;

public class SortElementFromTwoBinaryTree {

	public static void main(String[] args) {
		Node root1 = new Node(2);
		root1.left = new Node(1);
		root1.right = new Node(4);

		Node root2 = new Node(1);
		root2.left = new Node(0);
		root2.right = new Node(3);

		System.out.println(getAllElements(root1, root2));
	}

	public static List<Integer> getAllElements(Node root1, Node root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		inorder(root1, list1);
		inorder(root2, list2);

		return mergeList(list1, list2);
	}

	private static void inorder(Node root, List<Integer> res) {
		if (root == null)
			return;

		inorder(root.left, res);
		res.add(root.data);
		inorder(root.right, res);

	}
	
	private static List<Integer> mergeList(List<Integer> l1, List<Integer> l2) {
		int m = l1.size(), n = l2.size();
		int i = 0, j = 0;
		List<Integer> res = new ArrayList<>();

		while (i < m && j < n) {
			if (l1.get(i) < l2.get(j)) {
				res.add(l1.get(i));
				i++;
			} else {
				res.add(l2.get(j));
				j++;
			}
		}

		while (i < m) {
			res.add(l1.get(i));
			i++;
		}

		while (j < n) {
			res.add(l2.get(j));
			j++;
		}

		return res;
	}

}
