package queue;

/**
 * 动态顺序队列
 * 
 * @author Pink
 * @version : DynamicArrayQueue, v 0.1 2020年02月17日 22:20 Pink Exp $
 */
public class DynamicArrayQueue {
	// 数组
	private String[] items;
	// 队列容量
	private int n = 0;
	// 队头下标
	private int head = 0;
	// 队尾下标
	private int tail = 0;

	public DynamicArrayQueue(int capacity) {
		this.items = new String[capacity];
		this.n = capacity;
	}

	// 入队
	private boolean enqueue(String value) {
		// 队尾没有空间了
		if (tail == n) {
			//数组队列已满
			if (head == 0) {
				return false;
			}
			/***
			 * [0,0,0,4,5,6,7,0] ->[4,5,6,7,0,0,0,0]
			 * head = 3 ,tail = 7 -> head = 0 ,tail = 4
			 */
			for (int i = head; i < tail; i++) {
				items[i - head] = items[i];
			}
			tail = tail - head;
			head = 0;
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
		DynamicArrayQueue arrayQueue = new DynamicArrayQueue(5);
		arrayQueue.enqueue("1");
		arrayQueue.enqueue("2");
		arrayQueue.enqueue("3");
		arrayQueue.enqueue("4");
		arrayQueue.enqueue("5");
		System.out.println(arrayQueue.dequeue());
		System.out.println(arrayQueue.enqueue("6"));
		arrayQueue.printAll();

	}
}
