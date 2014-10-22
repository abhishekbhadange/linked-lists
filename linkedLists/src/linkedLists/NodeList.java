package linkedLists;

public class NodeList {
	private Node head;
	public NodeList() {}
	public Node insert(int data) {
		Node n = new Node(data);
		Node temp = head;
		if(temp == null)
			head = n;
		else {
			while(temp.next != null)
				temp = temp.next;
			temp.next = n;
		}
		return n;
	}
	public void printList() {
		Node n = head;
		if(!isEmpty()) {
			n.printNode();
			while(n.next != null) {
				n.next.printNode();
				n = n.next;
			}
			System.out.println("");
		}
		else
			System.out.println("Linked List is empty!");
	}
	public boolean isEmpty() {
		return (head == null);
	}
	public Node getHead() {
		return head;
	}
	public void setHead(Node n) {
		head = n;
	}
	public Node delete(int data) {
		Node n = head;
		if(!isEmpty()) {
			if(n.data == data) 
				return n.next;
			else {
				while(n.next != null) {
					if(n.next.data == data) {
						n.next = n.next.next;
						return head;
					}
					n = n.next;
				}
				return head;
			}
		}
		else 
			System.out.println("Linked List is empty!");
		return null;
	}
}
