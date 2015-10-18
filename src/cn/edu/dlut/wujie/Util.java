package cn.edu.dlut.wujie;

import java.util.Random;

public class Util {

	//shuffle a array to be sorted
	public static void shuffle(int[] a){
		if(a != null && a.length == 0 ) 
			return;
		int r = 0;
		Random random = new Random();
		for(int i = 0 ; i < a.length ; i++){
			//generate 0 - i random number,and swap a[r] with a[i]
			r = random.nextInt(i + 1);
			int swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}
	
	public static void generateSequenceNumArray(int[] a){
		for(int i = 0 ; i < a.length ; i ++)
			a[i] = i;
	}
		
	
	public static void printArray(int[] a,int numOfLine){
		for(int i = 0 ; i < a.length ; i++){
			if(i % numOfLine == 0)
				System.out.println("\n");
			System.out.print(a[i] + " ");
		}
	}

}
