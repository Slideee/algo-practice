package stack;

/**
 * 链式栈
 *
 * @author Pink
 *
 * @version $Id: StackBasedOnLinkedList, v 0.1 2020年02月16日 01:59:58  Pink Exp $
 */
public class StackBasedOnLinkedList {

	private Node top;

	// 入栈
	private void push(int value) {
		Node newNode = new Node(value, null);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	// 出栈
	private int pop() {
		if (top == null) {
			return -1;
		}
		int value = top.value;
		top = top.next;
		return value;
	}

	private void printAll() {
		Node p = top;
		while (p != null) {
			System.out.println(p.value + ",");
			p = p.next;
		}
		System.out.println();
	}

	private class Node {

		private int value;

		private Node next;

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		StackBasedOnLinkedList list = new StackBasedOnLinkedList();
		int i = 0;
		while (i < 5) {
			list.push(i);
			list.printAll();
			i++;
		}

		list.pop();
		list.printAll();
	}
}
