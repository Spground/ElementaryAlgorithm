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

		// 测试连通性
		System.err.println("2 与 7 连通吗？ " + wpcqu.find(2, 7));
		System.err.println("0 与 3 连通吗？ " + wpcqu.find(0, 3));
		System.err.println("0 与 6 连通吗？ " + wpcqu.find(0, 6));
		System.err.println("5 与 7 连通吗？ " + wpcqu.find(5, 7));
		
		System.err.println(wpcqu);
	}
	
	
}

//时间复杂度N objects problem set, init:O(N)、find:O(N * logN)、union：O(N * logN)
//union操作时，将小树接到大树下面，这样让树不会变得很瘦高，因此find操作回溯到树root时回溯的步数就会降低
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
			//路径压缩，将当前节点p的id[p]设置为爷节点的id[*]值
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
	 * 连接两个连通单元时，比较两个连同单元的节点数目，将节点数目多的
	 * 连接单元连接到节点数目多的连接单元，使得树矮胖(flat)一点
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		if(find(p, q))
			return;
		int pRoot = root(p);
		int qRoot = root(q);
		if (size[pRoot] > size[qRoot]) {
			// q 所在子树接到 p所在子树
			id[qRoot] = pRoot;
			size[pRoot] += size[qRoot];
		} else {
			// p 所在子树接到q所在子树
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