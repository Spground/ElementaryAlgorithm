package cn.edu.dlut.wujie;
/**
 * an improved insert sort method 
 * increments is not 1, instead of h.
 * 
 * key point£ºthe span of every exchange is no longer 1,but h;
 * tow basis
 * 1.Big increments ===> small subarray to be sorted,every ride
 * 2.Small increments ===> nearly in order(Insertion Sort is suitable for partial ordered array )
 * 
 * increments are big then,the size of the sub arrays that we're sorting are pretty small,
 * so any sorting method including Insertion Sort is going to work well.But when increments 
 * get small because we've done previous h-sort for bigger value of h,the array is partially 
 * sorted and Insertion sort is going to be fast!
 * 
 * the general increments sequence is 3*x + 1 eg£º1 4 13 40 121 364,...,1093,3280 ......
 * challenge:find the best increments sequence to make Shell Sort works best!
 * 
 * performance:10000000 random numbers cost about 163 seconds, 1000000 random numbers cost about 6 seconds at Intel i5-3210M 2.50GHz
 */
public class ShellSort {
	private static int[] a = new int[]{1,-4,55,8,3,2,9,56,32,10,99,102,35,69,68,2,
		26,33,22,0,-2,23,86,21,23,20,11,59,77,56,3,20,-9,-60,-61,90,56,19,1001};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shellSort(a,121);
		pintArray(a);
	}

	private static void shellSort(int[] a,int N){
		//A g-sorted array remains g-sorted after h-sorting it
		int h = N;
		while(h >= 1){
			//h-sorting 
			for(int i = 0 ; i < a.length ; i++){
				 for(int j = i; j >= h; j = j - h){
					 if(a[j - h] > a[j]){
						 int swap = a[j - h];
						 a[j - h] = a[j];
						 a[j] = swap;
					 }
					 else
						 break;
				 }
			}
			//adjust increments
			h = (h - 1) / 3;
		}
	}
	
	private static void pintArray(int[] a){
		for(int i = 0 ; i < a.length;i++){
			if(i % 20 == 0)
				System.out.println("");
			System.out.print(a[i] + " ");
		}
	}
	
}
