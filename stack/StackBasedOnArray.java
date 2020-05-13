package stack;

/**
 * 顺序栈
 * 
 * @author Pink
 *
 * @version $Id: StackBasedOnArray, v 0.1 2020年02月16日 02:00:38 Pink Exp $
 */
public class StackBasedOnArray {

	private int[] data;
	// 实际个数
	private int count;
	// 容量
	private int num;

	public StackBasedOnArray(int num) {
		this.data = new int[num];
		this.count = 0;
		this.num = num;
	}

	private boolean push(int value) {
		if (count == num) {
			return false;
		}
		data[count] = value;
		count++;
		return true;
	}

	private int pop() {
		if (count == 0) {
			return -1;
		}
		int tmp = data[count - 1];
		count--;
		return tmp;
	}

	private void printAll() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i] + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackBasedOnArray array = new StackBasedOnArray(5);
		int i = 0;
		while (i < 5) {
			array.push(i);
			i++;
		}
		array.printAll();
		System.out.println(array.pop());
	}

}
