package cn.edu.dlut.wujie;
/**
 * ��һ�����飬���������ÿһ�����ظ����飬����ֻ��һ������һ�飬�ҳ������
 *	XOR����������
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
