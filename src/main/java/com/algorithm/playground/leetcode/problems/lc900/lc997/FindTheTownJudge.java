package com.algorithm.playground.leetcode.problems.lc900.lc997;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class FindTheTownJudge {

	class Solution {
		public int findJudge(int N, int[][] trust) {
			int[] in = new int[N + 1];
			int[] out = new int[N + 1];
			for (int[] t : trust) {
				out[t[0]]++;
				in[t[1]]++;
			}
			for (int i = 1; i <= N; i++) {
				if (in[i] == N - 1 && out[i] == 0) {
					return i;
				}
			}
			return -1;
		}
	}

}
