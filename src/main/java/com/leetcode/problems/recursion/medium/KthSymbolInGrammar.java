package com.leetcode.problems.recursion.medium;

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
			String s = ch == '0' ? "01" : "10";
			int n = (1 << N - 1);
			int i = n / 2;
			if (K - i > 0) {
				return recursion(s.charAt(1), N - 1, K - i);
			} else {
				return recursion(s.charAt(0), N - 1, K);
			}
		}
	}

}
