package cn.edu.dlut.wujie;

/**
 * @author asus ���ַ�����
 * 
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[] { 1, 3, 5, 7, 9, 11, 35, 56, 89, 99,100 };
		System.out.println(binarySearchImproved(A,11 ));

	}

	/**
	 * @param A
	 * @param target
	 * @return index ����Ŀ��ֵ�������λ��
	 */
	public static int binarySearch(int[] A, int target) {
		int len = A.length;
		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target)
				return mid;
			if (A[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}

	/**
	 * @param A
	 * @param target
	 * @return ����Ŀ��������A�е��±�ֵ������Ҳ����ͷ������ֵӦ�ñ����뵽�����λ�õĵĸ���
	 */
	public static int binarySearchImproved(int[] A, int target) {

		int len = A.length;
		int left = 0, right = len - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		 if (left >= len || A[left] != target)
		   return -left -1 ;
		return left;
	}
}
