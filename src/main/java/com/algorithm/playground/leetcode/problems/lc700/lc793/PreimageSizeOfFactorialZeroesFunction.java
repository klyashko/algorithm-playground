package com.algorithm.playground.leetcode.problems.lc700.lc793;

/**
 * https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/
 * <p>
 * Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
 * <p>
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end.
 * Given K, find how many non-negative integers x have the property that f(x) = K.
 */
public class PreimageSizeOfFactorialZeroesFunction {

	class Solution {

		public int preimageSizeFZF(int K) {
			return findRange(K) - findRange(K - 1);
		}

		private int findRange(int k) {
			long low = 0, high = Long.MAX_VALUE;

			while (low <= high) {
				long mid = low + (high - low) / 2;
				if (countZeroes(mid) > k) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			return (int) low - 1;
		}

		private long countZeroes(long N) {
			long count = 0;
			for (long i = 5; N / i >= 1; i *= 5) {
				count += N / i;
			}
			return count;
		}

	}

}
