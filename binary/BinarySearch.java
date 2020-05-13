package binary;

/**
 * 二分查找
 *
 * @author Pink
 *
 * @version $Id: BinarySearch, v 0.1 2020年02月21日 13:21:53 Pink Exp $
 */
public class BinarySearch {

	public static int search(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] == value) {
				return mid;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// 递归实现
	public static int bsearch(int[] a, int n, int value) {
		return bsearchInternally(a, 0, n - 1, value);
	}

	public static int bsearchInternally(int[] a, int low, int high, int value) {
		if (low > high)
			return -1;

		int mid = low + ((high - low) >> 1);
		if (a[mid] == value) {
			return mid;
		} else if (a[mid] < value) {
			return bsearchInternally(a, mid + 1, high, value);
		} else {
			return bsearchInternally(a, low, mid - 1, value);

		}
	}

	// 查找第一个值等于给定值的元素
	public static int searchA(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] < value) {
				low = mid + 1;
			} else if (a[mid] > value) {
				high = mid - 1;
			} else {
				// 如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它肯定是我们要找的；如果 mid 不等于 0，但 a[mid]的前一个元素
				// a[mid-1]不等于 value，那也说明 a[mid]就是我们要找的第一个值等于给定值的元素。
				if (mid == 0 || a[mid - 1] != value)
					return mid;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

	// 查找最后一个值等于给定值的元素
	public static int searchB(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] < value) {
				low = mid + 1;
			} else if (a[mid] > value) {
				high = mid - 1;
			} else {
				if (mid == n - 1 || a[mid + 1] != value)
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	// 查找第一个大于等于给定值的元素
	public static int searchC(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				if (mid == 0 || a[mid - 1] < value)
					return mid;
				else
					high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	// 查找最后一个小于等于给定值的元素
	public static int searchD(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (a[mid] <= value) {
				if (mid == n - 1 || a[mid + 1] > value)
					return mid;
				else
					low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// System.out.println(BinarySearch.search(a, 8, 3));
		// System.out.println(BinarySearch.bsearch(a, 8, 6));
		int[] b = { 1, 3, 4, 5, 5, 8, 8, 8, 11, 17 };
		int[] c = { 3, 10, 10, 10, 10 };
		System.out.println(BinarySearch.searchA(b, 10, 8));
		System.out.println(BinarySearch.searchB(b, 10, 8));
		System.out.println(BinarySearch.searchC(c, 5, 10));
		System.out.println(BinarySearch.searchD(b, 10, 8));
	}
}