package cn.edu.dlut.wujie.princeton.union_find;

public class Weighted_Path_Compression_QuickUnion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_Weighted_Path_Compression_QuickUnion wpcqu = new _Weighted_Path_Compression_QuickUnion(8);
		wpcqu.union(0, 1);
		wpcqu.union(1, 3);

		wpcqu.union(2, 4);

		wpcqu.union(5, 6);
		wpcqu.union(6, 7);
		wpcqu.union(6, 1);

		// ������ͨ��
		System.err.println("2 �� 7 ��ͨ�� " + wpcqu.find(2, 7));
		System.err.println("0 �� 3 ��ͨ�� " + wpcqu.find(0, 3));
		System.err.println("0 �� 6 ��ͨ�� " + wpcqu.find(0, 6));
		System.err.println("5 �� 7 ��ͨ�� " + wpcqu.find(5, 7));
		
		System.err.println(wpcqu);
	}
	
	
}

//ʱ�临�Ӷ�N objects problem set, init:O(N)��find:O(N * logN)��union��O(N * logN)
//union����ʱ����С���ӵ��������棬�������������ú��ݸߣ����find�������ݵ���rootʱ���ݵĲ����ͻή��
class _Weighted_Path_Compression_QuickUnion {

	int id[];
	public int size[];

	public _Weighted_Path_Compression_QuickUnion(int N) {
		// TODO Auto-generated constructor stub
		this.id = new int[N];
		this.size = new int[N];
		for (int i = 0; i < N; i++) {
			this.id[i] = i;
			this.size[i] = 1;
		}
	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	private int root(int p) {
		while (p != id[p]) {
			//·��ѹ��������ǰ�ڵ�p��id[p]����Ϊү�ڵ��id[*]ֵ
			id[p] = id[id[p]];
			p = id[p];
		}
			
		return p;
	}

	/**
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	/**
	 * ����������ͨ��Ԫʱ���Ƚ�������ͬ��Ԫ�Ľڵ���Ŀ�����ڵ���Ŀ���
	 * ���ӵ�Ԫ���ӵ��ڵ���Ŀ������ӵ�Ԫ��ʹ��������(flat)һ��
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		if(find(p, q))
			return;
		int pRoot = root(p);
		int qRoot = root(q);
		if (size[pRoot] > size[qRoot]) {
			// q ���������ӵ� p��������
			id[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		} else {
			// p ���������ӵ�q��������
			id[pRoot] = qRoot;
			size[qRoot] += size[pRoot];
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for(int i = 0; i < size.length; i++) {
			str += (root(i) + " : " + size[root(i)] + "\n");
		}
		return str;
	}
}