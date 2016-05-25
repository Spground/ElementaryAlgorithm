package cn.edu.dlut.wujie.princeton.union_find;

public class QuickUnion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{0,1,3}、{2,4}、{5,6,7}
				_QuickUnion qu = new _QuickUnion(8);
				qu.union(0, 1);
				qu.union(1, 3);
				
				qu.union(2, 4);
				
				qu.union(5, 6);
				qu.union(6, 7);
				
				//测试连通性
				System.err.println("2 与 7 连通吗？ " + qu.find(2, 7));
				System.err.println("0 与 3 连通吗？ " + qu.find(0, 3));
				System.err.println("0 与 6 连通吗？ " + qu.find(0, 6));
				System.err.println("5 与 7 连通吗？ " + qu.find(5, 7));
	}

}

//时间复杂度N objects problem set,  init:O(N)、find:O(N * N)、union：O(N * N)
//find() is slow
class _QuickUnion {
	
	//1、id[i]'s value  is parent of ith node 
	//2、ith node's root：id[id[id[i]]]...keep going util it does not change
	int[] id;
	
	public _QuickUnion(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		for(int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * find root of a connected component
	 * @param p
	 * @return
	 */
	public int root(int p) {
		while(p != id[p])
			p = id[p];
		return p;
	}
	
	public boolean find(int p, int q) {
		if(p < 0 || q < 0 || q >= id.length || q >= id.length || id == null)
			return false;
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		//modify p's root as q's root
		//root node satisfied:id[ith] = ith
		if(find(p, q))
			return;
		int pRoot = root(p);
		id[pRoot] = root(q);
	}
}