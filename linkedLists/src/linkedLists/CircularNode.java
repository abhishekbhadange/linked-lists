// Given a circular linked list, implement an algorithm which 
// returns the node at the beginning of the loop, or detect 
// if a linked list has a loop.

package linkedLists;

public class CircularNode {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(5);
		list.insert(10);
		Node t = list.insert(2);
		list.insert(9);
		Node p = list.insert(12);
		p.next = t;
		Node result = circularNode(list.getHead());
		if(result != null)
			System.out.println(result.data);
	}	
	public static Node circularNode(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		if(fast == null || fast.next == null) {
			System.out.println("No loop exists in the Linked List!");
			return null;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}