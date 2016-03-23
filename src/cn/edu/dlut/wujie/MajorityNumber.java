package cn.edu.dlut.wujie;

//�ҵ������г��ֵĴ�������n / 2����
public class MajorityNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 2, 2, 6, 5, 5, 5, 5, 5};
		System.out.println("Majority Number is " + findMajorityNumber(nums));
	}
	
	public static int findMajorityNumber(int[] nums) {
		int[] bitCount = new int[32];//��¼��iλΪ��0��Ԫ�س��ֵĴ���
		int r = 0;
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(((nums[j] >> i) & 1) == 1)
					bitCount[i]++;
			}
			
			if(bitCount[i] > (nums.length / 2))
				r |= 1 << i;
		}
		return r;
	}

}
