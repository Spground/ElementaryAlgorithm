package cn.edu.dlut.wujie;

/**
 * ÿ�����������Σ�������һ����ֻ����һ�Σ��ҵ����ֻ���ֹ�һ�ε���
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
		//����һ��32���ȵ��������飬������¼�������������ĵ�iλ��1������֮��
		//����ÿ�����������Σ���ζ��,��iλ1���������ܺ�mod3����������Ϊ0����1
		//Ϊ1����λ�ض����Ǹ�singlenumber����λ
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
