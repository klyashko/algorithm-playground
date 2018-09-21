package com.leetcode.problems.greedy.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class AssignCookies {

	class Solution {
		public int findContentChildren(int[] g, int[] s) {
			Arrays.sort(g);
			Arrays.sort(s);
			int idx1 = 0;
			int idx2 = 0;
			int count = 0;
			while (idx1 < g.length && idx2 < s.length) {
				if (g[idx1] <= s[idx2]) {
					idx1++;
					idx2++;
					count++;
				} else {
					idx2++;
				}
			}
			return count;
		}
	}

}
