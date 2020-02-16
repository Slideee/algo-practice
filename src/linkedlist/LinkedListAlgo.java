package linkedlist;

/**
 * 1) 链表中环的检测
 *
 * @author Pink
 *
 * @version $Id: LinkedListAlgo, v 0.1 2020年02月17日 00:53:27 Pink Exp $
 */
public class LinkedListAlgo {

	// 检测环
	public static boolean checkCircle(Node list) {
		if (list == null)
			return false;

		Node fast = list.next;
		Node slow = list;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void printAll(Node list) {
		Node p = list;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	public static Node createNode(int value) {
		return new Node(value, null);
	}

	public static class Node {
		private int data;
		private Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}
	}

	public static void main(String[] args) {
		Node headNode = new Node(1, null);
		headNode.setNext(new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, headNode))))));
		System.out.println(checkCircle(headNode));

	}
}