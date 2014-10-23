// Reverse a linked list

package linkedLists;

public class ReverseList {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		Node head = reverseList(list.getHead());
		head.printNode();
		while(head.next != null) {
			head.next.printNode();
			head = head.next;
		}
		System.out.println("");
	}
	public static Node reverseList(Node head) {
		Node temp = null;
		Node current = head;
		Node next = head.next;
		while(next != null) {
			current.next = temp;
			temp = current;
			current = next;
			next = next.next;
		}
		current.next = temp;
		return current;
	}
}