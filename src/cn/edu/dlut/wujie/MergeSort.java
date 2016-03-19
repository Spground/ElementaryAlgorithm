package cn.edu.dlut.wujie;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[100000000];
		Util.generateSequenceNumArray(nums);
		Util.shuffle(nums);
		long timeStart = System.currentTimeMillis();
		mergeSort(nums, 0, nums.length - 1);
		System.out.println("ºÄÊ±===¡·" + (System.currentTimeMillis() - timeStart) / 1000 + "Ãë");
	}
	
	public static void mergeSort(int[] A, int left, int right) {
		if(left >= right)
			return;
		int mid = (left + right) / 2;
		mergeSort(A, left, mid);
		mergeSort(A, mid+1, right);
		merge(A, left, mid, right);
		return;
	}
	
	public static void merge(int[] A, int left, int mid, int right ) {
		int l = mid - left;
		int r = right - (mid + 1);
		
		int[] L = new int[l + 1];
		int[] R = new int[r + 1];
		
		for(int i = 0; i <= l; i++)
			L[i] = A[left + i];
		for(int i = 0; i <= r; i++)
			R[i] = A[mid + 1 + i];
		
		int i = 0, j = 0, k = 0;
		//merge
		while(i <= l && j <= r) {
			if(L[i] < R[j] )
				A[left + k++] = L[i++];
			else
				A[left + k++] = R[j++];
		}
		
		while(i <= l)
			A[left + k++] = L[i++];
		while(j <= r)
			A[left + k++] = R[j++];
		
	}
}
