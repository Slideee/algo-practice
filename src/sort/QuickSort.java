package sort;

/**
 * @author Pink
 * @version : QuickSort, v 0.1 2020年02月19日 19:18 Pink Exp $
 */
public class QuickSort {

	// 快速排序，a是数组，n表示数组的大小
	public static void quickSort(int[] a, int n) {
		quickSortInternally(a, 0, n - 1);
	}

	// 快速排序递归函数，p,r为下标
	private static void quickSortInternally(int[] a, int p, int r) {
		if (p >= r)
			return;
		int q = partition(a, p, r);
		quickSortInternally(a, p, q - 1);
		quickSortInternally(a, q + 1, r);

	}

	private static int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int i = p;
		for (int j = p; j < r; j++) {
			if (a[j] < pivot) {
				if (i == j) {
					i++;
				} else {
					int temp = a[i];
					a[i++] = a[j];
					a[j] = temp;
				}
			}
		}
		// a[i] swap a[r]
		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;
		System.out.println("i=" + i);
		return i;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 5, 6, 8, 7, 2, 4 };
		QuickSort.quickSort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}