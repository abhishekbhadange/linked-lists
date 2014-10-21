// An algorithm to delete a node of a singly linked list,
// given only access to that node.

package linkedLists;

public class DeleteNode {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(12);
		list.insert(5);
		list.insert(9);
		list.insert(3);
		list.insert(15);
		list.printList();
		Node head = list.getHead();
		for(int i = 0; i < 2; i++)
			head = head.next;
		boolean result = deleteNode(head);
		System.out.println(result);
		list.printList();
	}
	public static boolean deleteNode(Node n) {
		if(n == null || n.next == null)
			return false;
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
}