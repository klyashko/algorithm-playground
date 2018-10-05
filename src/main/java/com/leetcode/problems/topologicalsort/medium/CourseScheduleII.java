package com.leetcode.problems.topologicalsort.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/description/
 */
@SuppressWarnings("ConstantConditions")
public class CourseScheduleII {

	class Solution {
		public int[] findOrder(int numCourses, int[][] prerequisites) {
			Map<Integer, List<Integer>> edges = new HashMap<>();
			for (int[] e : prerequisites) {
				if (!edges.containsKey(e[0])) {
					edges.put(e[0], new ArrayList<>());
				}
				edges.get(e[0]).add(e[1]);
			}

			int[] colors = new int[numCourses];
			LinkedList<Integer> stack = new LinkedList<>();

			for (int i = 0; i < colors.length; i++) {
				if (colors[i] == 0 && !dfs(edges, colors, i, stack)) {
					return new int[0];
				}
			}

			int[] ans = new int[numCourses];

			for (int i = 0; i < ans.length; i++) {
				ans[i] = stack.pollLast();
			}

			return ans;
		}

		private boolean dfs(Map<Integer, List<Integer>> edges, int[] colors, int curr, LinkedList<Integer> stack) {
			/** 0 - waite, 1 - gray, 2 - black */
			if (colors[curr] > 0) {
				return colors[curr] == 2;
			}
			colors[curr] = 1;
			for (Integer next : edges.getOrDefault(curr, Collections.emptyList())) {
				if (!dfs(edges, colors, next, stack)) {
					return false;
				}
			}
			colors[curr] = 2;
			stack.push(curr);
			return true;
		}
	}

}
