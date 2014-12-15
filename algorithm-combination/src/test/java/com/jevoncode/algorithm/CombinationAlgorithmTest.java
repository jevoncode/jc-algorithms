package com.jevoncode.algorithm;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class CombinationAlgorithmTest {

	@Test
	public void testOptimizedCombinate() {
		// int n = 7;
		// int m = 6;
		// long expectedReuslt = 7;
		// int n = 8;
		// int m = 6;
		// long expectedReuslt = 28;
		int n = 13;
		int m = 6;
		long expectedReuslt = 1716;
		CombinationAlgorithm c = new CombinationAlgorithm(n, m);
		long result = c.combinate();
		Assert.assertArrayEquals(new long[] { expectedReuslt },
				new long[] { result });
	}

}
