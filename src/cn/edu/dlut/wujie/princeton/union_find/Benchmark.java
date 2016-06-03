package cn.edu.dlut.wujie.princeton.union_find;

public class Benchmark {
	public static final int N = 4 * 100 * 1000* 1000;
	/**weightedquickunion 4亿数据， union操作12秒 
	 * WeightedQuickUnionPathCompression 4亿数据 union操作13秒
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试union操作
//		testQuickFind();
//		testQuickUnion();
//		testWeightedQuickUnion();
		testWeightedQuickUnionPathCompression();
	}

	public static void testQuickFind() {
		_QuickFind qf = new _QuickFind(N);
		System.err.println("------QuickFind union() start...---------");
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			if(i < N - 1)
				qf.union(i, i+1);
			showProgress(i, N);
		}
		long costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------QuickUnion union() cost " + costTime / 1000 + " senconds-------");
		
		//测试find操作 随即find 1000 个数
		int[] testIndex = genRandomIndex(1000, N);
		startTime = System.currentTimeMillis();
		System.err.println("------QuickFind find() [1000 find ops] start...---------");
		for(int i = 0; i < 999; i++) {
			qf.find(testIndex[i], testIndex[i + 1]);
		}
		costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------QuickFind find() [1000 find ops] cost " + costTime / 1000 + " senconds-------");
	}
	
	public static void testQuickUnion() {
		_QuickUnion qu = new _QuickUnion(N);
		System.err.println("------QuickUnion union() start...---------");
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			if(i < N - 1)
				qu.union(i, i+1);
			showProgress(i, N);
		}
		long costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------QuickUnion union() cost " + costTime / 1000 + " senconds-------");
		
		//测试find操作 随即find 1000 个数
		int[] testIndex = genRandomIndex(1000, N);
		startTime = System.currentTimeMillis();
		System.err.println("------QuickUnion find() [1000 find ops] start...---------");
		for(int i = 0; i < 999; i++) {
			qu.find(testIndex[i], testIndex[i + 1]);
		}
		costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------QuickUnion find() [1000 find ops] cost " + costTime / 1000 + " senconds-------");
	}
	
	public static void testWeightedQuickUnion() {
		_WeightedQuickUnion wqu = new _WeightedQuickUnion(N);
		System.err.println("------WeightedQuickUnion union() start...---------");
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			if(i < N - 1)
				wqu.union(i, i+1);
			showProgress(i, N);
		}
		long costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------WeightedQuickUnion union() cost " + costTime / 1000 + " senconds-------");
		
		//测试find操作 随即find 100000 个数
		int[] testIndex = genRandomIndex(1000000, N);
		startTime = System.currentTimeMillis();
		System.err.println("------WeightedQuickUnion find() [1000000 find ops] start...---------");
		for(int i = 0; i < 999999; i++) {
			wqu.find(testIndex[i], testIndex[i + 1]);
		}
		costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------WeightedQuickUnion find() [1000000 find ops] cost " + costTime / 1000 + " senconds-------");
	}
	
	public static void testWeightedQuickUnionPathCompression() {
		_Weighted_Path_Compression_QuickUnion wqu = new _Weighted_Path_Compression_QuickUnion(N);
		System.err.println("------_Weighted_Path_Compression_QuickUnion union() start...---------");
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			if(i < N - 1)
				wqu.union(i, i+1);
//			wqu.find((int)Math.random() * i, (int)(Math.random() * i + 1));
			showProgress(i, N);
		}
		long costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------_Weighted_Path_Compression_QuickUnion union() cost " + costTime / 1000 + " senconds-------");
		
		//测试find操作 随即find 1000000 个数
		startTime = System.currentTimeMillis();
		System.err.println("------_Weighted_Path_Compression_QuickUnion find() [1000 find ops] start...---------");
		int[] testIndex = genRandomIndex(1000000, N);
		for(int i = 0; i < 999999; i++) {
			wqu.find(testIndex[i], testIndex[i + 1]);
		}
		costTime = System.currentTimeMillis() - startTime;
		System.err.println("-------_Weighted_Path_Compression_QuickUnion find() [1000 find ops] cost " + costTime / 1000 + " senconds-------");
	}
	
	/**
	 * 随机生成测试下标
	 * @param n
	 * @param maxRange
	 * @return
	 */
	public static int[] genRandomIndex(int n, int maxRange) {
		int testIndex[] = new int[n];
		for(int i = 0; i < n; i++) {
			testIndex[i] = (int) (Math.random() * maxRange);
		}
		return testIndex;
	}
	
	/**
	 * 显示进度
	 * @param curN
	 * @param N
	 */
	public static void showProgress(int curN, int N) {
		float percent = 1.0f * curN / N; 
		if(percent == 0.2f || percent == 0.4f || percent == 0.6f || percent == 0.8f || percent == 1.0f )
			System.err.println("--------progress is " + (percent * 100) + "%--------");
	}
}
