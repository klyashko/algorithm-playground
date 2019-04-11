package com.algorithm.playground.leetcode.problems.lc800.lc850.lc850;

import java.util.*;

/**
 * https://leetcode.com/problems/rectangle-area-ii/description/
 */
public class RectangleAreaII {

	class Solution {
		public int rectangleArea(int[][] rectangles) {
			int mod = 1_000_000_007;
			Set<Integer> xVals = new HashSet<>();
			Set<Integer> yVals = new HashSet<>();
			for (int[] r : rectangles) {
				xVals.add(r[0]);
				xVals.add(r[2]);

				yVals.add(r[1]);
				yVals.add(r[3]);
			}

			Integer[] x = xVals.toArray(new Integer[0]);
			Integer[] y = yVals.toArray(new Integer[0]);

			Arrays.sort(x);
			Arrays.sort(y);

			Map<Integer, Integer> xIndexes = new HashMap<>();
			Map<Integer, Integer> yIndexes = new HashMap<>();

			int idx = 0;
			for (Integer i : x) {
				xIndexes.put(i, idx++);
			}
			idx = 0;
			for (Integer i : y) {
				yIndexes.put(i, idx++);
			}

			boolean[][] grid = new boolean[y.length][x.length];

			for (int[] r : rectangles) {
				for (int row = yIndexes.get(r[1]); row < yIndexes.get(r[3]); row++) {
					for (int col = xIndexes.get(r[0]); col < xIndexes.get(r[2]); col++) {
						grid[row][col] = true;
					}
				}
			}

			long area = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j]) {
						long w = x[j + 1] - x[j];
						long h = y[i + 1] - y[i];
						area += w * h;
					}
				}
			}

			return (int) (area % mod);
		}
	}

}
