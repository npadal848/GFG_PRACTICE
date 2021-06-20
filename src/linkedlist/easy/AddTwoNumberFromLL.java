package linkedlist.easy;

import java.util.Scanner;
import java.util.Stack;

public class AddTwoNumberFromLL {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		Node first = new Node(-1);
		Node curr1 = first;
		while (n1-- > 0) {
			curr1.next = new Node(sc.nextInt());
			curr1 = curr1.next;
		}
		first = first.next;
		
		int n2 = sc.nextInt();
		Node second = new Node(-1);
		Node curr2 = second;
		while (n2-- > 0) {
			curr2.next = new Node(sc.nextInt());
			curr2 = curr2.next;
		}
		second = second.next;
		Node head = addTwoLists(first, second);
		head.print();
	}
	
	static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Stack<Integer> s1=new Stack<>();
        Node curr = first;
        while(curr!=null){
            s1.push(curr.data);
            curr = curr.next;
        }
        Stack<Integer> s2=new Stack<>();
        curr = second;
        while(curr!=null){
            s2.push(curr.data);
            curr = curr.next;
        }

        int carry = 0;   
        Stack<Integer> stack=new Stack<>();
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum=carry;
            if(!s1.isEmpty()){
                sum+=s1.pop();
            }
            if(!s2.isEmpty()){
                sum+=s2.pop();
            }
            stack.push(sum%10);
            carry = sum/10;
        }
        Node head = new Node(-1);
        curr = head;
        while(!stack.isEmpty()){
            curr.next = new Node(stack.pop());
            curr = curr.next;
        }
        return head.next;
    }
	
}
