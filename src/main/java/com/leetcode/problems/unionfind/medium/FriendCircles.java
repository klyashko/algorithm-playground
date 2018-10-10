package com.leetcode.problems.unionfind.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/friend-circles/description/
 */
public class FriendCircles {

	class Solution {
		public int findCircleNum(int[][] M) {
			if (M.length == 0) {
				return 0;
			}
			int[] parents = new int[M.length];
			Arrays.fill(parents, -1);
			for (int r = 0; r < M.length; r++) {
				for (int c = 0; c < M.length; c++) {
					if (M[r][c] == 1) {
						int p1 = find(parents, r);
						int p2 = find(parents, c);
						if (p1 != p2) {
							parents[p1] = p2;
						}
					}
				}
			}
			Set<Integer> values = new HashSet<>();
			for (int i = 0; i < parents.length; i++) {
				values.add(find(parents, i));
			}
			return values.size();
		}

		private int find(int[] parents, int key) {
			if (parents[key] == -1) {
				return parents[key] = key;
			} else if (parents[key] == key) {
				return key;
			}
			return parents[key] = find(parents, parents[key]);
		}
	}

}
