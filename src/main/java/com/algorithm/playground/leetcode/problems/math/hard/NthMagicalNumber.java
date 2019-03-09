package com.algorithm.playground.leetcode.problems.math.hard;

/**
 * https://leetcode.com/problems/nth-magical-number/description/
 */
public class NthMagicalNumber {

	class Solution {
		public int nthMagicalNumber(int N, long A, long B) {
			int mod = 1_000_000_007;
			long lo = 0;
			long hi = Long.MAX_VALUE;
			long lcm = A / gcd(A, B) * B;

			while (lo < hi) {
				long mi = lo + (hi - lo) / 2;
				long c = mi / A + mi / B - mi / lcm;
				if (c < N)
					lo = mi + 1;
				else
					hi = mi;
			}

			return (int) (lo % mod);
		}

		private long gcd(long A, long B) {
			if (A == 0) {
				return B;
			}
			return gcd(B % A, A);
		}
	}

}
