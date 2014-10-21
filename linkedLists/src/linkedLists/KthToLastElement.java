// An algorithm to find the kth to last element of a singly linked list

package linkedLists;

public class KthToLastElement {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(12);
		list.insert(5);
		list.insert(9);
		list.insert(3);
		list.insert(15);
		int k = 2;
		int result = kToLast(list, k);
		System.out.println(result);
	}
	public static int kToLast(NodeList list, int k) {
		if(list.isEmpty() || list == null) {
			System.out.println("Error: Empty list! exiting...");
			System.exit(0);
		}
		if(k < 0){
			System.out.println("Error: k < 0! exiting...");
			System.exit(0);
		}
		Node current = list.getHead();
		Node runner = list.getHead();
		int m = 0;
		while(m < k && runner.next != null) {
			runner = runner.next;
			m++;
		}
		if(runner.next == null){
			System.out.println("Error: k's value is equal to or greater than the Linked List size! exiting...");
			System.exit(0);
		}
		while(runner.next != null) {
			current = current.next;
			runner = runner.next;
		}
		return current.data;
	}
}