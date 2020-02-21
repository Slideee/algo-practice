package binary;

/**
 * @author Pink
 * @version : QuickSort, v 0.1 2020年02月19日 19:18 Pink Exp $
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

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// System.out.println(BinarySearch.search(a, 8, 3));
		System.out.println(BinarySearch.bsearch(a, 8, 6));

	}
}