package sort;

/**
 * 冒泡排序、插入排序、选择排序
 *
 * @author Pink
 * @version : Sorts, v 0.1 2020年02月19日 1:07 Pink Exp $
 */
public class Sorts {

	public void bubbleSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int tem = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tem;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}

	}

	// 插入排序，a表示数组，n表示数组大小
	public static void insertionSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 1; i < n; i++) {
			int value = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (a[j] > value) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = value;
		}

	}

	public static void selectSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int tem = a[i];
			a[i] = a[min];
			a[min] = tem;
		}

	}

	public static void main(String[] args) {
		Sorts sort = new Sorts();
		// int[] a = { 3, 1, 5, 6, 8, 7, 2 };
		// sort.bubbleSort(a, a.length);

		// Sorts.insertionSort(a, a.length);
		// Sorts.selectSort(a, a.length);
		//
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(a[i]);
		// }

		// 111
		int a = 7;
		// 110
		int b = 6;
		// 110
		System.out.println(a & b);
		// 111
		System.out.println(a | b);
		// 001
		System.out.println(a ^ b);
		// 0100
		System.out.println(a >>> 1);

	}
}
