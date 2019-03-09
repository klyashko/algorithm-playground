package com.algorithm.playground.leetcode.problems.recursion.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/special-binary-string/description/
 */
public class SpecialBinaryString {

	class Solution {
		public String makeLargestSpecial(String S) {
			return dfs(S, new int[]{0});
		}

		private String dfs(String s, int[] i) {
			StringBuilder res = new StringBuilder();
			List<String> tokens = new ArrayList<>();
			while (i[0] < s.length()) {
				if (s.charAt(i[0]++) == '1') {
					tokens.add(dfs(s, i));
				} else {
					res.append('1');
					break;
				}
			}
			boolean prefix = res.length() > 0;
			Collections.sort(tokens);
			for (int j = tokens.size() - 1; j >= 0; j--) {
				res.append(tokens.get(j));
			}
			if (prefix) {
				res.append('0');
			}
			return res.toString();
		}
	}

}
