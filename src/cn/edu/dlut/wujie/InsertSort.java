package cn.edu.dlut.wujie;

/**
 * compared with left elements 
 * exchange if less than left element
 * this method is suitable for partial ordered array;
 * 
 **/
public class InsertSort {

	private static int[] a = new int[]{1,-4,55,8,3,2,9,56,32,10,99,102,35,69,68,2,
		26,33,22,0,-2,23,86,21,23,20,11,59,77,56,3,20,-9,-60,-61,90,56,19,1001};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertSort(a);
		pintArray(a);
	}

	private static void insertSort(int[] a){
		
		for(int i = 0 ; i < a.length ; i++){
			for(int j = i ; j > 0 ; j--){
				int swap;
				//exchange if less than left element
				if(a[j - 1] > a[j]){
					swap = a[j - 1];
					a[j - 1] = a[j];
					a[j] = swap;
				}
				else
					break;
			}
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
