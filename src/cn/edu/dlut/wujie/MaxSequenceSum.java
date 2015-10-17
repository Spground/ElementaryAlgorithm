package cn.edu.dlut.wujie;

/**
 * @author asus
 * 最大子序列
 * 递归实现，左右分治的思想
 *
 */
public class MaxSequenceSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSequenceSum maxSequence = new MaxSequenceSum();
			int[] a = new int[]{1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,2,1,-6,6,7,8,9,-8,-4,21,-6,6,7,8,9,-8,-4,2};
			System.out.println(maxSequence.maxSub(a, 0,70));
	}
	
	public int maxSub(int[] a ,int left,int right){
		
	
		if(left == right)
			if(a[left] > 0 )
				return a[left];
			else
				return 0;
		
		int center = (left + right) / 2;
		int leftMax = maxSub(a,left,center);
		int rightMax = maxSub(a, center+1, right);
		
		int maxLeftBorder = 0 ,maxRightBorder = 0 ;
		int thisSum = 0;
		for(int i = center;i >= left ;i--){
			thisSum += a[i];
			if(thisSum > maxLeftBorder)
				maxLeftBorder = thisSum;
		}
		
		thisSum = 0 ;
		for(int i = center + 1;i <= right ;i++){
			thisSum += a[i];
			if(thisSum > maxRightBorder)
				maxRightBorder = thisSum;
		}
		
		return max((maxLeftBorder + maxRightBorder),leftMax,rightMax);
	}
	
	private int max(int a ,int b ,int c){
		
		return a > b ? (a > c ? a :c):(b > c ? b : c);
	}

}
