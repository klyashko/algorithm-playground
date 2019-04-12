package com.algorithm.playground.leetcode.problems.lc600.lc650.lc657;

/**
 * https://leetcode.com/problems/robot-return-to-origin/
 */
public class JudgeRouteCircle {

	class Solution {
		public boolean judgeCircle(String moves) {
			if (moves.length() % 2 == 1) {
				return false;
			}

			int l = 0, r = 0, u = 0, d = 0;

			for (char cr : moves.toCharArray()) {
				switch (cr) {
					case 'L':
						l++;
						break;
					case 'R':
						r++;
						break;
					case 'U':
						u++;
						break;
					case 'D':
						d++;
				}
			}
			return l == r && u == d;
		}
	}

}
