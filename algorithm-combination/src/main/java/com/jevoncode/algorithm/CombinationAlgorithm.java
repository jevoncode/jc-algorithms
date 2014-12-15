package com.jevoncode.algorithm;

/**
 * n和m分别是排列组合公式C(n,m)中的n和m
 * 
 * @author jevoncode
 *
 */
public class CombinationAlgorithm {
	private int n;
	private int m;
	private int count = 0;

	public CombinationAlgorithm(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}

	/**
	 * 列组合公式C(n,m),经过优化的
	 * 该算法，n<=2m时，时间复杂度为O(n)=(n-m)<=m
	 * 当n>2m时,时间复杂度为O(n)=2m
	 * @return
	 */
	public long optimizedCombinate() {
		if (n > m * 2) 
			return function(n, n - m) / function(m);
		else
			return function(n, m) / function(n - m);
	}

	/**
	 * 列组合公式C(n,m)
	 * 该算法,时间复杂度为O(n)=(n-m),即与n有关,n越大,O(n)越大
	 * @return
	 */
	public long combinate() {
		long b = function(n - m); 
		return function(n, m) /b;

	}

	/**
	 * function(n,m) = n!/m!
	 * 
	 * @param max
	 * @param min
	 * @return
	 */
	private long function(long max, int min) {
		min = min == 0 ? 1 : min;
		if (max == min)
			return 1;
		else
			return max * function(max - 1, min);
	}

	private long function(long max) {
		return function(max, 0);
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		int n = 71; //当为72时,超过long的最大值,所以导致function方法的结果为0,从而跑出除数为0异常
		int m = 6;
		long expectedReuslt = 1716;
		CombinationAlgorithm c = new CombinationAlgorithm(n, m);
		long result = c.combinate();
		System.out.println("reuslt=" + result + ",count=" + c.getCount());
		
		CombinationAlgorithm c2 = new CombinationAlgorithm(n, m);
		long result2 = c2.optimizedCombinate();
		System.out.println("reuslt2=" + result2 + ",count2=" + c2.getCount());
	}
}
