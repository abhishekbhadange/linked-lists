// Partition a linked list around a value x, such that all nodes less than x
// come before all nodes greater than or equal to x.

package linkedLists;

public class PartitionList {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(12);
		list.insert(5);
		list.insert(9);
		list.insert(3);
		list.insert(15);
		list.printList();
		Node n = partitionList(list.getHead(), 10);
		n.printNode();
		while(n.next != null) {
			n.next.printNode();
			n = n.next;
		}
		System.out.println("");
	}
	public static Node partitionList(Node n, int x) {
		Node beforeStart = null;
		Node afterStart = null;
		while(n != null) {
			Node next = n.next;
			if(n.data < x) {
				n.next = beforeStart;
				beforeStart = n;
			}
			else {
				n.next = afterStart;
				afterStart = n;
			}
			n = next;
		}
		if(beforeStart == null)
			return afterStart;
		Node temp = beforeStart;
		while(temp.next != null) 
			temp = temp.next;
		temp.next = afterStart;
		return beforeStart;
	}
}