package cn.edu.dlut.wujie;

/**
 * QuickSort
 * performence:average case:O(nlogn) wrongest case:O(n*n),  best case:O(nlogn)
 *  
 *  #init:choose a[low] as partitioning element
 *  #phase1:repeat until i and j pointers cross
 * 		.scan i from left to right as long as a[i] < a[low]
 * 		.scan j from right to left as long as a[j] > a[low]
 *  #phase2:when i & j pointers cross,the j pointer must point the 
 *   element that is not bigger than partitioning element.so exchange a[low] with a[j],
 *   which will still maintain the invariant that no element to be left are bigger than a[low]
 *   and no element to be right are less than a[low];
 *   
 *   another tips:shuffle the array to be sorted,avoid the wrong case
 *   
 *   test:0.5billion numbers cost about 111seconds
 */

public class QuickSort {

	/**
	 * @param args
	 */
	private static int[] a = new int[]{1,-4,55,8,3,2,9,56,32,10,99,102,35,69,68,2,
		26,33,22,0,-2,23,86,21,23,20,11,59,77,56,3,20,-9,-60,-61,90,56,19,1001};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] a = new int[500000000];
		Util.generateSequenceNumArray(a);*/
		Util.shuffle(a);
		Util.printArray(a, 50);
		quickSort(a,0,a.length - 1);
		Util.printArray(a, 50);
	}
	
	//partition array
	public static int partition(int[] a , int lo ,int hi){
		//choose the a[lo] element as the pivot (or partitioning ) element
		int i = lo,j = hi + 1;
		int swap;
		while(true){
			//scan i pointer,stop while a[i] bigger than a[lo]
			while(a[lo] >= a[++i])
				if(i == hi)
					break;
			//scan j pointer ,stop while a[j] less than a[lo]
			//if(j == lo) break actually is redundant,cause j pointer will stop
			//at the position of a[lo],a[lo] >= a[lo] is true
			while(a[--j] >= a[lo])
				if(j == lo)
					break;
			
			//i & j pointer cross , break;
			if(i >= j)
				break;
			
			//exchange a[i] with a[j]
			swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}
		
		//exchange a[j] with a[lo]
		swap = a[j];
		a[j] = a[lo];
		a[lo] = swap;
		
		return j;
	}

	//quick sort
	public  static void quickSort(int[] a , int lo,int hi){
		if(hi <= lo) 
			return;
		int j = partition(a, lo, hi);
		quickSort(a,lo,j - 1);
		quickSort(a,j + 1 , hi);
	}
	
}
