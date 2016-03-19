package cn.edu.dlut.wujie;

public class SingleNumber3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 2, 1, 2 , 3, 5, 5, 6, 7, 3};
		System.out.println(findDistinctTowNumber(nums)[0]);
		System.out.println(findDistinctTowNumber(nums)[1]);
	}
	
	public static int[] findDistinctTowNumber(int[] nums) {
		int diff = 0;
		for(int num : nums) 
			diff ^= num;
		
		//得到nums数组中XOR结果中的最后一位bit位为1的值 
		//a &= -a就是得到a最后一位bit位为1的值
		//例如6 & -6 6 ==> 0110，-6 ==> 1010; 0110 & 1010 得 0010
		diff &= -diff;
		
		int[] result = new int[]{0, 0};
		
		for(int num : nums) {
			if((num & diff) == 0)
				result[0] ^= num;
			else
				result[1] ^= num;
		}
		return result;
	}
}
