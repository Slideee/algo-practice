package queen;

/**
 * 循环队列
 * 
 * @author Pink
 * @version : CircularQueue, v 0.1 2020年02月17日 22:43 Pink Exp $
 */
public class CircularQueue {

	private String[] items;

	private int n = 0;

	private int head = 0;

	private int tail = 0;

	public CircularQueue(int capacity) {
		items = new String[capacity];
		n = capacity;
	}

	private boolean enqueue(String value) {
		if ((tail + 1) % n == head) {
			return false;
		}
		items[tail] = value;
		// 成环
		tail = (tail + 1) % n;
		return true;
	}

	private String dequeue() {
		if (head == tail) {
			return null;
		}
		String tmp = items[head];
		head = (head + 1) % n;
		return tmp;
	}

	public void printAll() {
		for (int i = head; i < tail; ++i) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CircularQueue arrayQueue = new CircularQueue(5);
		arrayQueue.enqueue("1");
		arrayQueue.enqueue("2");
		arrayQueue.enqueue("3");
		arrayQueue.enqueue("4");
		arrayQueue.enqueue("5");
		//arrayQueue.dequeue();
		System.out.println("head:" + arrayQueue.head);
		System.out.println("tail:" + arrayQueue.tail);
		arrayQueue.printAll();
	}
}
