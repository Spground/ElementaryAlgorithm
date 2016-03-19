package cn.edu.dlut.wujie;

public class SetZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] martrix = {
				{1,2,3,4},
				{5,0,5,2},
				{8,9,2,0},
				{5,7,2,1}
				};
		setZeroes(martrix);
		
		for(int i = 0; i < martrix.length; i++){
			System.out.println();
			for(int j = 0; j < martrix[0].length; j++)
				System.out.print(" " + martrix[i][j]);
		}
			
	}
	
	private static void setZeroes(int[][] matrix){
		 	int rows = matrix.length;
			int cols = matrix[0].length;
			
			//sepcail case
			if(rows <= 1 || cols <= 1){
				boolean zero = false;
				for(int i = 0; i < rows; i++)
					for(int j = 0; j < cols; j++)
						if(matrix[i][j] == 0)
							zero = true;
				if(zero)
					for(int i = 0; i < rows; i++)
						for(int j = 0; j < cols; j++)
							matrix[i][j] = 0;
			}
			
			// add a extra variable k 
			int k = matrix[0][0];
			
			//save first row and first column's info
			//to decide whether set them as zero
			for(int i = 0; i < rows; i++)
				if(matrix[i][0] == 0)
				    k = 0;
			for(int j = 0; j < cols; j++)
				if(matrix[0][j] == 0)
				    matrix[0][0] = 0;
			
			//use a[i][0] and a[0][j] to save a[i][j]'s info if a[i][j] is 0
			for(int i = 1; i < rows; i++)
				for(int j = 1; j < cols; j++)
					if(matrix[i][j] == 0){
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}	
			
			for(int i = 1; i < rows; i++)
				if(matrix[i][0] == 0)
					for(int j = 1; j < cols; j++)
						matrix[i][j] = 0;
			
			for(int j = 1; j < cols; j++)
				if(matrix[0][j] == 0)
					for(int i = 1; i < rows; i++)
						matrix[i][j] = 0;
			
			//set first row and first column
			if(matrix[0][0] == 0)
				for(int j = 0; j < cols; j++)
					matrix[0][j] = 0;
			
			if(k == 0)
				for(int i = 0; i < rows; i++)
					matrix[i][0] = 0;			
	}
}
