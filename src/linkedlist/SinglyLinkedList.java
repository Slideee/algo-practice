package linkedlist;

/**
 * 1）单链表的插入、删除、查找操作； 2）链表中存储的是int类型的数据；
 *
 * @author Pink
 *
 * @version $Id: SinglyLinkedList, v 0.1 2020年02月15日 18:50:13 Pink Exp $
 */
public class SinglyLinkedList {

	private Node head;

	// public SinglyLinkedList() {
	// this.head = new Node(0, null);
	// }

	public Node findByValue(int value) {
		Node p = head;
		while (p != null && p.getValue() != value) {
			p = p.next;
		}
		return p;
	}

	private Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while (p != null && pos != index) {
			p = p.next;
			pos++;
		}
		return p;
	}

	// 无头结点
	// 表头部插入
	// 这种操作将于输入的顺序相反，逆序
	public void insertToHead(int value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		// 存在实例化的头结点时
		// Node next = head.getNext();
		// head.setNext(new Node(value, next));
	}

	// 顺序插入
	// 链表尾部插入
	private void insertTail(int value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
		} else {
			Node p = head;
			while (p.next != null) {
				p = p.next;
			}
			newNode.next = p.next;
			p.next = newNode;
		}

	}

	private void insertAfter(Node p, int value) {
		Node newNode = new Node(value, null);
		if (p == null) {
			return;
		}
		newNode.next = p.next;
		p.next = newNode;
	}

	private void insertBefore(Node p, int value) {
		Node newNode = new Node(value, null);
		if (p == null) {
			return;
		}
		if (head == p) {
			insertToHead(value);
			return;
		}
		Node q = head;
		// 查p的前驱
		while (q != null && q.next != p) {
			q = q.next;
		}
		newNode.next = p;
		q.next = newNode;
	}

	private void deleteByNode(Node p) {
		if (p == null || head == null) {
			return;
		}
		// 删除头节点，那么他的next就是头节点了
		if (p == head) {
			head = head.next;
			return;
		}
		Node q = head;
		// 找到p的前驱q
		while (q != null && q.next != p) {
			q = q.next;
		}
		q.next = q.next.next;
	}

	private void deleteByValue(int value) {
		if (head == null || head.value == value) {
			head = head.next;
			return;
		}
		Node p = head;
		while (p.next != null) {
			if (p.next.value == value) {
				p.next = p.next.next;
			}
			p = p.next;
		}

	}

	private void printAll() {
		Node node = head.getNext();
		while (node != null) {
			System.out.print(node.getValue() + ",");
			node = node.getNext();
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

		SinglyLinkedList link = new SinglyLinkedList();
		int i = 1;
		// while (i < 5) {
		//// link.insertTail(i);
		//// i++;
		//// link.printAll();
		//// }
		while (i < 5) {
			link.insertToHead(i);
			link.printAll();
			i++;
		}
		System.out.println(link.findByValue(3).getValue());
		System.out.println(link.findByIndex(3).getValue());
		link.deleteByValue(2);
		link.printAll();
	}
}