package sort;

/**
 * 归并排序
 * 
 * @author Pink
 * @version : MergeSort, v 0.1 2020年02月19日 16:16 Pink Exp $
 */
public class MergeSort {

	// 归并排序算法, a是数组，n表示数组大小
	public static void mergeSort(int[] a, int n) {
		mergeSortInternally(a, 0, n - 1);
	}

	// 递归调用函数
	private static void mergeSortInternally(int[] a, int p, int r) {
		// 递归终止条件
		if (p >= r) {
			return;
		}
		// 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
		int q = p + (r - p) / 2;
		// 分治递归
		mergeSortInternally(a, p, q);
		mergeSortInternally(a, q + 1, r);
		// 将A[p...q]和A[q+1...r]合并为A[p...r]
		merge(a, p, q, r);

	}

	private static void merge(int[] a, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int k = 0;
		int[] temp = new int[r - p + 1];
		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		// 是否还有剩余数组
		int start = i;
		int end = q;
		if (j <= r) {
			start = j;
			end = r;
		}
		// 把剩余的数放到temp里
		while (start <= end) {
			temp[k++] = a[start++];
		}
		// temp[] -> a[]
		for (i = 0; i < r - p + 1; i++) {
			a[p + i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 5, 6, 8, 7, 2, 4 };
		MergeSort.mergeSort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
