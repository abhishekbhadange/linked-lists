// Code to calculate the addition of two numbers stored in reverse order in linked lists
// (7 -> 1 -> 6) + (5 -> 9 -> 2) = 2 -> 1 -> 9

package linkedLists;
 
public class ReverseAddition {
	public static void main(String[] args) {
		NodeList list1 = new NodeList();
		list1.insert(7);
		list1.insert(1);
		list1.insert(6);
		NodeList list2 = new NodeList();
		list2.insert(5);
		list2.insert(9);
		list2.insert(2);
		Node n = reverseAddition(list1.getHead(), list2.getHead(), 0);
		n.printNode();
		while(n.next != null) {
			n.next.printNode();
			n = n.next;
		}
		System.out.println("");
		NodeList list3 = new NodeList();
		list3.insert(6);
		list3.insert(1);
		list3.insert(7);
		NodeList list4 = new NodeList();
		list4.insert(2);
		list4.insert(9);
		list4.insert(5);
		Node n1 = forwardAddition(list3.getHead(), list4.getHead());
		n1.printNode();
		while(n1.next != null) {
			n1.next.printNode();
			n1 = n1.next;
		}
		System.out.println("");
	}
	public static Node reverseAddition(Node head1, Node head2, int carry) {
		if(head1 == null && head2 == null && carry == 0)
			return null;
		int value = carry;
		if(head1 != null)
			value += head1.data;
		if(head2 != null)
			value += head2.data;
		Node result = new Node(value % 10);
		if(head1 != null || head2 != null) {
			Node temp = reverseAddition(head1 == null ? null : head1.next,
										head2 == null ? null : head2.next,
										value >= 10 ? 1 : 0);
			result.next = temp;
		}
		return result;
	}
	public static class PartialSum {
		Node sum = null;
		int carry = 0;
	}
	public static Node forwardAddition(Node head1, Node head2) {
		int len1 = length(head1);
		int len2 = length(head2);
		if(len1 < len2)
			head1 = padList(head1, len2 - len1);
		else
			head2 = padList(head2, len1 - len2);
		PartialSum ps = addLists(head1, head2);
		if(ps.carry == 0)
			return ps.sum;
		else {
			Node n = insertBefore(ps.sum, ps.carry);
			return n;
		}
	}
	public static int length(Node head) {
		int counter = 0;
		if(head == null)
			return 0;
		while(head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}
	public static Node padList(Node head, int count) {
		for(int i = 0; i < count; i++) {
			Node n = new Node(0);
			n.next = head;
			head = n;
		}
		return head;
	}
	public static PartialSum addLists(Node head1, Node head2) {
		if(head1 == null && head2 == null) {
			PartialSum ps = new PartialSum();
			return ps;
		}
		PartialSum ps = addLists(head1.next, head2.next);
		int value = ps.carry + head1.data + head2.data;
		Node fullResult = insertBefore(ps.sum, value % 10);
		ps.sum = fullResult;
		ps.carry = value / 10;
		return ps;
	}
	public static Node insertBefore(Node head, int value) {
		Node n = new Node(value);
		if(head != null) 
			n.next = head;
		return n;
	}
}