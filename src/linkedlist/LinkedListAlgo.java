package linkedlist;

/**
 * 1) 链表中环的检测 2)单链表反转
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

	// 单链表反转
	// 思路，每次循环截掉一个头结点，把头结点逆序生成一个新的单链表
	public static Node reverse(Node list) {
		Node curr = list;
		// 反转链表
		Node pre = null;
		while (curr != null) {
			Node next = curr.next;// 截掉头结点
			curr.next = pre;// 第一次循环头结点的next为null，1. 1->null 2. 2->1->null 3. 3->2->1->null
			pre = curr;// 赋值给新生成的逆序单链表
			curr = next;// 重新赋值一个截掉一次头结点的单链表,因为每次截掉头节点,实际上就是headNode=headNode.next，这样在第二步的时候可以以该headNode生成单链表。
		}
		return pre;
	}

	public static Node findMiddleNode(Node list) {
		if (list == null) {
			return null;
		}
		Node fast = list;
		Node slow = list;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
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
		headNode.setNext(new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, null)))))));
		// // System.out.println(checkCircle(headNode));
		// printAll(headNode);
		// printAll(reverse(headNode));

		printAll(findMiddleNode(headNode));

	}
}