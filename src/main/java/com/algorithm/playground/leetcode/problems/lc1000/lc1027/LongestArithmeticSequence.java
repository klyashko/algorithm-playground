package com.algorithm.playground.leetcode.problems.lc1000.lc1027;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 */
public class LongestArithmeticSequence {

	class Solution {
		public int longestArithSeqLength(int[] A) {
			@SuppressWarnings("unchecked")
			Map<Integer, Integer>[] dp = new HashMap[A.length];
			for (int i = 0; i < A.length; i++) {
				dp[i] = new HashMap<>();
				for (int j = A.length - 1; j > i; j--) {
					dp[i].put(A[j] - A[i], j);
				}
			}
			int max = 0;
			for (int i = 0; i < A.length; i++) {
				Map<Integer, Integer> curr = dp[i];
				for (Integer diff : curr.keySet()) {
					int count = 1;
					Map<Integer, Integer> tmp = curr;
					while (tmp.containsKey(diff)) {
						tmp = dp[tmp.get(diff)];
						count++;
					}
					max = Math.max(max, count);
				}
			}
			return max;
		}
	}

}
