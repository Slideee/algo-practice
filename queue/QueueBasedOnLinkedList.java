package queue;

/**
 * 基于链表实现的队列
 *
 * @author Pink
 * @version : QueueBasedOnLinkedList, v 0.1 2020年02月17日 22:03 Pink Exp $
 */
public class QueueBasedOnLinkedList {

	private Node head = null;

	private Node tail = null;

	// 入队
	private void enqueue(String data) {
		if (tail == null) {
			Node newNode = new Node(data, null);
			head = newNode;
			tail = newNode;
		} else {
			tail.next = new Node(data, null);
			tail = tail.next;
		}
	}

	// 出队
	private String dequeue() {
		if (head == null) {
			return null;
		}
		String value = head.getData();
		head = head.next;
		// 注意只有一个元素时，出队后要考虑tail的情况。
		if (head == null) {
			tail = null;
		}
		return value;
	}

	public class Node {

		private String data;

		private Node next;

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.println(p.getData() + "");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueBasedOnLinkedList arrayQueue = new QueueBasedOnLinkedList();
		arrayQueue.enqueue("1");
		System.out.println("de:" + arrayQueue.dequeue());
		System.out.println("head:" + arrayQueue.head);
		System.out.println("tail:" + arrayQueue.tail);
		arrayQueue.printAll();
	}
}
