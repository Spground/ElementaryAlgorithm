package cn.edu.dlut.wujie;

public class CountPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = countPrime(1000);
		System.out.println(count);
	}

	//Count the number of prime numbers less than a non-negative number, n
	private static int countPrime(int n){
		int count=0;
        boolean[] nums = new boolean[n];
        for(int i = 2; i < nums.length; i++){
            if(!nums[i]){
                count++;
                //key point:set nums[k * i] as false,because these numbers no more be prime
                //which can reduce the inner for-loop times 
                for(int j = 2*i; j < nums.length; j = j + i){
                        nums[j] = true;
                }
            }
        }
        return count;
	}
}
