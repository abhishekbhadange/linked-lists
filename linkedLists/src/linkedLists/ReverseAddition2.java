package linkedLists;

public class ReverseAddition2 {
	public static void main(String[] args) {
		NodeList firstNumber = new NodeList();
		firstNumber.insert(7);
		firstNumber.insert(1);
		firstNumber.insert(6);
		System.out.println("First number: ");
		firstNumber.printList();
		NodeList secondNumber = new NodeList();
		secondNumber.insert(5);
		System.out.println("Second number: ");
		secondNumber.printList();
		NodeList sum = addNumbers(firstNumber.head, secondNumber.head);
		System.out.println("Addition: ");
		sum.printList();
		NodeList fwdFirstNumber = new NodeList();
		fwdFirstNumber.insert(6);
		fwdFirstNumber.insert(1);
		fwdFirstNumber.insert(7);
		System.out.println();
		System.out.println("First number: ");
		fwdFirstNumber.printList();
		NodeList fwdSecondNumber = new NodeList();
		fwdSecondNumber.insert(4);
		fwdSecondNumber.insert(9);
		fwdSecondNumber.insert(5);
		System.out.println("Second number: ");
		fwdSecondNumber.printList();
		NodeList addition = addForwardNumbers(fwdFirstNumber.head, fwdSecondNumber.head);
		System.out.println("Result: ");
		addition.printList();
	}
	public static NodeList addNumbers(Node head1, Node head2) {
		NodeList addition = new NodeList();
		int carry = 0;
		while(head1 != null || head2 != null) {
			int result = carry + ((head1 != null) ? head1.data : 0) + ((head2 != null) ? head2.data : 0);
			carry = 0;
			if(result/10 == 1)
				carry = 1;
			addition.insert(result % 10);
			if(head1 != null)
				head1 = head1.next;
			if(head2 != null)
				head2 = head2.next;
		}
		if(carry == 1)
			addition.insert(carry);
		return addition;
	}
	public static NodeList addForwardNumbers(Node head1, Node head2) {
		Node next;
		Node revNum1 = null;
		Node revNum2 = null;
		Node revAddition = null;
		while(head1 != null) {
			next = head1.next;
			head1.next = revNum1;
			revNum1 = head1;
			head1 = next;
		}
		while(head2 != null) {
			next = head2.next;
			head2.next = revNum2;
			revNum2 = head2;
			head2 = next;
		}
		NodeList revResult = addNumbers(revNum1, revNum2);
		Node head3 = revResult.head;
		while(head3 != null) {
			next = head3.next;
			head3.next = revAddition;
			revAddition = head3;
			head3 = next;
		}
		NodeList finalList = new NodeList();
		finalList.head = revAddition;
		return finalList;
	}
}
