package cn.edu.dlut.wujie.leetcode;
//判断某个整数是否是2的幂
public class PowerOf2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1 is power of 2 ? " + isPowerOfTow(1));
		System.out.println("0 is power of 2 ? " + isPowerOfTow(0));
		printBits(8);
	}
	
	/**
	 *  位运算，2的幂说明其二进制数只有一位为1
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTow(int n) {
		return (((n & (n - 1)) == 0) && n != 0 );
	}
	
	public  static void printBits(int n) {
		for(int i = 31; i >= 0; i-- ) {
			System.out.print(((n >> i) & 1));
		}
	}
}
