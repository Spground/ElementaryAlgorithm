package cn.edu.dlut.wujie;
/**
 * selection sort 
 * find min element in right, place it in left
 *
 */

public class SelectionSort {

	/**
	 * @param args
	 */
	private static int[] a = new int[]{1,-4,55,8,3,2,9,56,32,10,99,102,35,69,68,2,
		26,33,22,0,-2,23,86,21,23,20,11,59,77,56,3,20,-9,-60,-61,90,56,19,1001};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectionSort(a);
		pintArray(a);
	}

	private static void selectionSort(int[] a){
		for(int i = 0 ; i < a.length; i++){
			int minIndex = i;
			
			//find the index of min element in right every ride
			for(int j = i ; j < a.length;j++)
				if(a[j] < a[minIndex])
					minIndex = j;			
			
			//exchange element
			int swap = a[i];
			a[i] = a[minIndex];
			a[minIndex] = swap;
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
