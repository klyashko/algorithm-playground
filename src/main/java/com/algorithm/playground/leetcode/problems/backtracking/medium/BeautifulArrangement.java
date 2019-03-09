package com.algorithm.playground.leetcode.problems.backtracking.medium;

/**
 * https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {

	class Solution {
		public int countArrangement(int N) {
			return backtracking(1, N, new boolean[N + 1]);
		}

		private int backtracking(int idx, int N, boolean[] used) {
			if (idx == N + 1) {
				return 1;
			}
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!used[i] && (i % idx == 0 || idx % i == 0)) {
					used[i] = true;
					count += backtracking(idx + 1, N, used);
					used[i] = false;
				}
			}
			return count;
		}
	}

}
