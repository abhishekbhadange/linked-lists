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
		Node n = reverseAddition(list1.getHead(), list2.getHead());
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
	public static Node reverseAddition(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return null;
		StringBuilder sb1 = new StringBuilder();
		while(head1 != null) {
			sb1.append(head1.data);
			head1 = head1.next;
		}
		StringBuilder sb2 = new StringBuilder();
		while(head2 != null) {
			sb2.append(head2.data);
			head2 = head2.next;
		}
		int value1 = Integer.valueOf(sb1.reverse().toString());
		int value2 = Integer.valueOf(sb2.reverse().toString());
		int result = value1 + value2;
		String res = String.valueOf(result);
		Node tail = new Node(Character.getNumericValue(res.charAt(0)));
		for(int i = 1; i < res.length(); i++) {
			Node temp = new Node(Character.getNumericValue(res.charAt(i)));
			temp.next = tail;
			tail = temp;
		}
		return tail;
	}
	public static Node forwardAddition(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return null;
		StringBuilder sb1 = new StringBuilder();
		while(head1 != null) {
			sb1.append(head1.data);
			head1 = head1.next;
		}
		StringBuilder sb2 = new StringBuilder();
		while(head2 != null) {
			sb2.append(head2.data);
			head2 = head2.next;
		}
		int value1 = Integer.valueOf(sb1.toString());
		int value2 = Integer.valueOf(sb2.toString());
		int result = value1 + value2;
		String res = String.valueOf(result);
		Node n = new Node(Character.getNumericValue(res.charAt(0)));
		Node head = n;
		for(int i = 1; i < res.length(); i++) {
			Node temp = new Node(Character.getNumericValue(res.charAt(i)));
			n.next = temp;
			n = temp;
		}
		return head;
	}
}