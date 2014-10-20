// Code to remove duplicates from an unsorted linked list.

package linkedLists;

import java.util.HashSet;

public class RemoveDuplicates {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.insert(12);
		list.insert(5);
		list.insert(9);
		list.insert(3);
		list.insert(12);
		list.insert(9);
		list.insert(15);
		System.out.println("Original: ");
		list.printList();
		removeDuplicates(list);
		System.out.println("Modified: ");
		list.printList();
		list.insert(5);
		list.insert(9);
		System.out.println("Original: ");
		list.printList();
		altRemoveDuplicates(list);
		System.out.println("Modified: ");
		list.printList();
	}
	public static void removeDuplicates(NodeList list) {
		if(list.isEmpty() || list == null) {
			System.out.println("Error: Empty list! exiting...");
			System.exit(0);
		}
		Node n = list.getHead();
		HashSet<Integer> set = new HashSet<Integer>();
		if(n != null)
			set.add(n.data);
		else
			System.out.println("Error: Null head!");
		while(n.next != null) {
			if(set.contains(n.next.data)) {
				Node temp = list.delete(n.next.data);
				list.setHead(temp);
			}
			else
				set.add(n.next.data);
			n = n.next;
		}
	}
	// No buffer allowed
	public static void altRemoveDuplicates(NodeList list) {		
		if(list.isEmpty() || list == null) {
			System.out.println("Error: Empty list! exiting...");
			System.exit(0);
		}
		Node head = list.getHead();
		Node current = head;
		while(current != null) {
			Node runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
	}
}