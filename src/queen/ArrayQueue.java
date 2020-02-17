package queen;

/**
 * 顺序队列
 * 
 * @author Pink
 * @version : ArrayQueue, v 0.1 2020年02月17日 21:50 Pink Exp $
 */
public class ArrayQueue {
	// 数组
	private String[] items;
	// 队列容量
	private int n = 0;
	// 队头下标
	private int head = 0;
	// 队尾下标
	private int tail = 0;

	public ArrayQueue(int capacity) {
		this.items = new String[capacity];
		this.n = capacity;
	}

	// 入队
	private boolean enqueue(String value) {
		if (tail == n) {
			return false;
		}
		items[tail] = value;
		tail++;
		return true;
	}

	// 出队
	private String dequeue() {
		if (head == tail) {
			return null;
		}
		String tem = items[head];
		head++;
		return tem;
	}

	public void printAll() {
		for (int i = head; i < tail; ++i) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue("1");
		arrayQueue.enqueue("2");
		arrayQueue.enqueue("3");
		arrayQueue.enqueue("4");
		arrayQueue.enqueue("5");
		System.out.println(arrayQueue.enqueue("6"));
		System.out.println(arrayQueue.dequeue());
		arrayQueue.printAll();

	}
}
