package studentpractice.NguyenPhiTruong;

public class MergeSort {
	public void mergeSort(int[] a,int L, int R) {
		if (L < R) {
			int tmp = (L+R)/2;
			mergeSort(a,L,tmp);
			mergeSort(a,tmp+1,R);
			merge(a,L,tmp,R);
		}
	}
	public void merge(int[] a, int L, int tmp, int R) {
		int i = L;
		int j = tmp + 1;
		
	}
}
