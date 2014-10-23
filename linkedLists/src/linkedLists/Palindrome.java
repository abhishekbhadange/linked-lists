// Implement a function to check if a linked list is a palindrome.

package linkedLists;

import java.util.Stack;

public class Palindrome {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(1);
		list.insert(2);
		list.insert(5);
		list.insert(2);
		list.insert(1);
		boolean result = palindrome(list.getHead());
		System.out.println(result);
	}
	public static boolean palindrome(Node head) {
		if(head == null)
			return false;
		Stack<Integer> stack = new Stack<Integer>();
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null)
			slow = slow.next;
		while(slow != null) {
			int value = stack.pop();
			if(value != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}
}