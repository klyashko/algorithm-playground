package com.algorithm.playground.leetcode.problems.lc800.lc887;

/**
 * https://leetcode.com/problems/super-egg-drop/
 */
public class SuperEggDrop {

	class Solution {

		public int superEggDrop(int K, int N) {
			int lo = 1, hi = N;
			while (lo < hi) {
				int mi = (lo + hi) / 2;
				if (f(mi, K, N) < N) {
					lo = mi + 1;
				} else {
					hi = mi;
				}
			}
			return lo;
		}

		private int f(int x, int K, int N) {
			int ans = 0, r = 1;
			for (int i = 1; i <= K && ans < N; i++) {
				r *= x - i + 1;
				r /= i;
				ans += r;
			}
			return ans;
		}
	}

}
