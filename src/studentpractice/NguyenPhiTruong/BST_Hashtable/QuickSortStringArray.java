package studentpractice.NguyenPhiTruong.BST_Hashtable;

public class QuickSortStringArray {
	public void swap(String[] a, int i, int j) {
		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public int partition(String[] a, int L, int R, int indexPivot) {
		String pivot;
		pivot = a[indexPivot];
		int storeIndex = L;
		swap(a, indexPivot, R);
		for (int i = L; i < R; i++) {
			if (a[i].compareTo(pivot) < 0) {
				swap(a, i, storeIndex);
				storeIndex++;
			}
		}
		swap(a, storeIndex, R);
		return storeIndex;
	}

	public void quickSort(String[] a, int L, int R) {
		if (L < R) {
			int index = (L + R) / 2;
			index = partition(a, L, R, index);
			if (L < index)
				quickSort(a, L, index - 1);
			if (index < R)
				quickSort(a, index + 1, R);
		}
	}
}
