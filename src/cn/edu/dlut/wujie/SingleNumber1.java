package cn.edu.dlut.wujie;
/**
 * 有一个数组，里面的数字每一个都重复两遍，但是只有一个出现一遍，找出这个数
 *	XOR的运算性质
 *	a XOR b = b XOR a;
 *	a XOR b XOR c = a XOR (b XOR c);
 *	a XOR 0 = a
 *	a XOR a = 0
 * @author asus
 *
 */
public class SingleNumber1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 2, 1, 2, 3, 5, 5};
		System.out.println("the single number is " + findSingleNumber(nums));
	}
	
	public static int findSingleNumber(int[] nums) {
		int diff = 0;
		for(int num : nums) 
			diff ^= num;
		return diff;
	}
}
