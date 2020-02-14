package linkedlist;

import java.util.Scanner;

/**
 * 基于单链表LRU算法（java）
 *
 * 我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 * 
 * @author Pink
 *
 * @version $Id: LRUBaseLinkedList, v 0.1 2020年02月14日 22:00:46 Pink Exp $
 */
public class LRUBaseLinkedList {
	// 容量
	private int capacity = 5;
	// 长度
	private int length = 0;
	// 头结点
	private SNode headNode;

	public LRUBaseLinkedList(int capacity, int length, SNode headNode) {
		this.capacity = capacity;
		this.length = length;
		this.headNode = headNode;
	}

	public LRUBaseLinkedList() {
		this.headNode = new SNode();
		this.capacity = 5;
		this.length = 0;
	}

	public void add(int data) {
		// 查找前驱节点
		SNode preNode = findPreNode(data);

		if (preNode != null) {
			// 删除当前前驱节点的next
			deletePreNodeNext(preNode);
			// 头部插入一个新的Node，表示最新
			insertStart(data);
		} else {
			// 容量未满时，
			if (length < capacity) {
				// 直接插入
				insert(data);
			} else {
				// 删除尾节点
				deleteEndNode();
				// 直接插入
				insert(data);
			}
		}

	}

	public void insertStart(int data) {
		SNode first = headNode.getNext();
		headNode.setNext(new SNode(data, first));
		length++;
	}

	public void deletePreNodeNext(SNode preNode) {
		SNode node = preNode.getNext();
		preNode.setNext(node.getNext());
		node = null;
		length--;
	}

	public void deleteEndNode() {
		SNode node = headNode;
		if (node.getNext() == null) {
			return;
		}
		while (node.getNext().getNext() != null) {
			node = node.getNext();
		}
		SNode endNode = node.getNext();
		node.setNext(null);
		endNode = null;
		length--;

	}

	public void insert(int data) {
		SNode nextNode = headNode.getNext();
		headNode.setNext(new SNode(data, nextNode));
		length++;
	}

	public SNode findPreNode(int data) {
		SNode node = headNode;
		while (node.getNext() != null) {
			// 只有当capacity撑满时，再进来一个已经存在的元素，我们从头节点开始遍历，当当前node的next的值等于data时，该node就为值为data的节点的前驱节点
			if (data == node.getNext().getElement()) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	private void printAll() {
		SNode node = headNode.getNext();
		while (node != null) {
			System.out.print(node.getElement() + ",");
			node = node.getNext();
		}
		System.out.println();
	}

	public class SNode {

		private int element;

		private SNode next;

		public SNode(int element, SNode next) {
			this.element = element;
			this.next = next;
		}

		public SNode() {
			this.next = null;
		}

		public int getElement() {
			return element;
		}

		public void setElement(int element) {
			this.element = element;
		}

		public SNode getNext() {
			return next;
		}

		public void setNext(SNode next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LRUBaseLinkedList list = new LRUBaseLinkedList();
		Scanner sc = new Scanner(System.in);
		while (true) {
			list.add(sc.nextInt());
			list.printAll();
		}

	}
}