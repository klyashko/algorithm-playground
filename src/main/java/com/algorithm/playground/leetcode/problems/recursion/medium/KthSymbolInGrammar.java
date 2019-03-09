package com.algorithm.playground.leetcode.problems.recursion.medium;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/description/
 */
public class KthSymbolInGrammar {

	class Solution {
		public int kthGrammar(int N, int K) {
			return recursion('0', N, K) - '0';
		}

		private char recursion(char ch, int N, int K) {
			if (N == 1) {
				return ch;
			}
			int n = (1 << N - 1) / 2;
			if (K - n > 0) {
				return recursion(ch == '0' ? '1' : '0', N - 1, K - n);
			} else {
				return recursion(ch == '0' ? '0' : '1', N - 1, K);
			}
		}
	}

}
