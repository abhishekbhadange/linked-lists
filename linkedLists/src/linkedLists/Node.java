package linkedLists;

public class Node {
	Node next;
	int data;
	public Node(int d) {
		data = d;
	}
	public void printNode() {
		System.out.print(data + " ");
	}
}
