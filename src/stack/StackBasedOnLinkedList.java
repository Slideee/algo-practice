package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 链式栈
 *
 * @author Pink
 *
 * @version $Id: StackBasedOnLinkedList, v 0.1 2020年02月16日 01:59:58 Pink Exp $
 */
public class StackBasedOnLinkedList {

	private Node top;

	// 入栈
	private void push(String value) {
		Node newNode = new Node(value, null);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	// 出栈
	private String pop() {
		if (top == null) {
			return null;
		}
		String value = top.value;
		top = top.next;
		return value;
	}

	/***
	 * {[]()[{}]}或[{()}([])]等都为合法格式，而{[}()]或[({)]为不合法的格式。那我现在给你一个包含三种括号的表达式字符串，如何检查它是否合法呢？
	 */
	public boolean checkString(List<String> values) {

		for (String value : values) {
			if (value.equals("{") || value.equals("[") || value.equals("(")) {
				push(value);
			} else {
				String left = pop();
				if (left == null) {
					return false;
				}
				if (value.equals("}")) {
					if (left.equals("{")) {
						continue;
					} else {
						return false;
					}
				} else if (value.equals(")")) {
					if (left.equals("(")) {
						continue;
					} else {
						return false;
					}
				} else {
					if (left.equals("[")) {
						continue;
					} else {
						return false;
					}
				}
			}
		}
		return true;
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

		private String value;

		private Node next;

		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
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
//
//		list.push("1");
//		list.push("2");
//		list.push("3");
//		list.push("4");
//		list.push("5");
//		list.printAll();
//
//		list.pop();
//		list.printAll();

		List<String> values = new ArrayList<>();
		values.add("{");
		values.add("[");
		values.add("]");
		values.add("[");
		values.add("{");
		values.add("}");
		values.add("]");
		values.add("}");
		System.out.println(list.checkString(values));
	}
}
