package com.leetcode.problems.heap.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/description/
 */
public class TheSkylineProblem {

	class Solution {
		public List<int[]> getSkyline(int[][] buildings) {
			if (buildings.length == 0) {
				return Collections.emptyList();
			}
			List<int[]> ans = new ArrayList<>();
			int len = 0;
			for (int[] b : buildings) {
				len = Math.max(len, b[1]);
				if (len > 1_000_000) {
					break;
				}
			}
			if (len < 1_000_000) {
				int[] heights = new int[len + 2];
				for (int[] b : buildings) {
					for (int i = b[0]; i <= b[1]; i++) {
						heights[i] = Math.max(heights[i], b[2]);
					}
				}
				int height = 0;
				for (int i = 0; i < heights.length; i++) {
					int h = heights[i];
					if (h > height) {
						ans.add(new int[]{i, h});
						height = h;
					} else if (h < height) {
						ans.add(new int[]{i - 1, h});
						height = h;
					}

				}
			} else {
				/** Handling large integers  */
				int end = 0;
				List<int[]> tmp = new ArrayList<>();
				for (int[] b : buildings) {
					if (b[0] <= end) {
						tmp.add(b);
						end = Math.max(end, b[1]);
					} else {
						ans.addAll(getSkyline(tmp));
						tmp.clear();
						tmp.add(b);
						end = b[1];
					}
				}
				ans.addAll(getSkyline(tmp));
			}
			return ans;
		}

		private List<int[]> getSkyline(List<int[]> buildings) {
			List<int[]> dots = new ArrayList<>();
			for (int[] b : buildings) {
				dots.add(new int[]{b[0], b[2]});
				dots.add(new int[]{b[1], b[2]});
			}
			dots.sort(Comparator.comparingInt(p -> p[0]));
			LinkedList<Integer> stack = new LinkedList<>();
			List<int[]> ans = new ArrayList<>();
			stack.push(0);
			for (int[] p : dots) {
				//noinspection ConstantConditions
				if (p[1] > stack.peek()) {
					ans.add(new int[]{p[0], p[1]});
					stack.push(p[1]);
				} else if (p[1] == stack.peek()) {
					stack.pop();
					ans.add(new int[]{p[0], stack.peek()});
				} else {
					int idx = stack.lastIndexOf(p[1]);
					if (idx == -1) {
						int tmp = stack.pop();
						stack.push(p[1]);
						stack.push(tmp);
					} else {
						stack.remove(idx);
					}
				}
			}
			return ans;
		}
	}

}
