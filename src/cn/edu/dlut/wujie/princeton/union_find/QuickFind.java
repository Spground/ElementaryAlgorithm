package cn.edu.dlut.wujie.princeton.union_find;

public class QuickFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{0,1,3}��{2,4}��{5,6,7}
		_QuickFind qf = new _QuickFind(8);
		qf.union(0, 1);
		qf.union(1, 3);
		
		qf.union(2, 4);
		
		qf.union(5, 6);
		qf.union(6, 7);
		
		//������ͨ��
		System.err.println("2 �� 7 ��ͨ�� " + qf.find(2, 7));
		System.err.println("0 �� 3 ��ͨ�� " + qf.find(0, 3));
		System.err.println("0 �� 6 ��ͨ�� " + qf.find(0, 6));
		System.err.println("5 �� 7 ��ͨ�� " + qf.find(5, 7));
	}

}
//ʱ�临�Ӷ� N objects problem set:init O(N) ��find O(1)��union O(N*N)
class _QuickFind {
	int[] id;
	public _QuickFind(int N) {
		// TODO Auto-generated constructor stub
		this.id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
	
	/**
	 * 
	 * @param p
	 * @param q
	 * @return p��q�Ƿ���ͨ
	 */
	public boolean find(int p, int q) {
		if(p < 0 || q < 0 || q >= id.length || q >= id.length || id == null)
			return false;
		return id[p] == id[q];
	}
	
	/**
	 * ����id[q]������ֵͬ��id[*]��Ϊ��id[p]��ֵ
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		for(int i = 0; i < id.length; i++)
			if(id[q] == id[i])
				id[i] = id[p];
	}
}