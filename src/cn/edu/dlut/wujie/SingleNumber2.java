package cn.edu.dlut.wujie;

/**
 * 每个数出现三次，但是有一个数只出现一次，找到这个只出现过一次的数
 * @author asus
 *
 */
public class SingleNumber2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 2, 3 , 4, 4 , 3, 2 , 1, 6,4 , 3, 2 , 1 };
		System.out.println(singleNumber2(nums));
	}
	
	public static int singleNumber2(int[] A) {
		//定义一个32长度的整形数组，用来记录数组中所有数的第i位的1的数量之和
		//由于每个数出现三次，意味着,第i位1的数量的总和mod3的余数可能为0或者1
		//为1的那位必定是那个singlenumber的那位
		int[] count = new int[32];
		int n = A.length;
		int result = 0;
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < n ;j++) {
				if(((A[j] >> i) & 1) == 1)
					count[i]++;
			}
			result |= ((count[i] % 3 ) << i); 
		}
		
		return result;
	}
}
