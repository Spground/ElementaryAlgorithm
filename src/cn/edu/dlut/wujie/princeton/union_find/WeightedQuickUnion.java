package cn.edu.dlut.wujie.princeton.union_find;

public class WeightedQuickUnion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// {0,1,3}、{2,4}、{5,6,7}
		_WeightedQuickUnion wqu = new _WeightedQuickUnion(8);
		wqu.union(0, 1);
		wqu.union(1, 3);

		wqu.union(2, 4);

		wqu.union(5, 6);
		wqu.union(6, 7);
		wqu.union(6, 1);

		// 测试连通性
		System.err.println("2 与 7 连通吗？ " + wqu.find(2, 7));
		System.err.println("0 与 3 连通吗？ " + wqu.find(0, 3));
		System.err.println("0 与 6 连通吗？ " + wqu.find(0, 6));
		System.err.println("5 与 7 连通吗？ " + wqu.find(5, 7));
		
		System.err.println(wqu);
	}

}

//时间复杂度N objects problem set, init:O(N)、find:O(logN)、union：O(logN)
//union操作时，将小树接到大树下面，这样让树不会变得很瘦高，因此find操作回溯到树root时回溯的步数就会降低
class _WeightedQuickUnion {

	int id[];
	public int size[];

	public _WeightedQuickUnion(int N) {
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
		while (p != id[p])
			p = id[p];
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