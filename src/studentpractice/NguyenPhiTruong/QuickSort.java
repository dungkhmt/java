package studentpractice.NguyenPhiTruong;

public class QuickSort {
//	public static int[] a;
	public void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}

	public int partition(int[] a, int L, int R, int indexPivot) {
		int pivot = a[indexPivot];
		swap(a, indexPivot, R);
		int storeIndex = L;
		for (int i = L; i < R; i++) {
			if (a[i] < pivot) {
				swap(a, storeIndex, i);
				storeIndex++;
			}
		}
		swap(a, storeIndex, R);
		return storeIndex;
	}

	public void quicksort(int[] a, int L, int R) {
		if (L < R) {
			int index = (L + R) / 2;
			index = partition(a, L, R, index);
			if (L < index)
				quicksort(a, L, index - 1);
			if (index < R)
				quicksort(a, index + 1, R);
		}
	}
}
