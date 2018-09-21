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
			int count = 0;
			for (int i = 0; i < s.length && count < g.length; i++) {
				if (g[count] <= s[i]) {
					count++;
				}
			}
			return count;
		}
	}

}
