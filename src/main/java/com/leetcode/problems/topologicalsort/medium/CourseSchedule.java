package com.leetcode.problems.topologicalsort.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {

	class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			Map<Integer, List<Integer>> edges = new HashMap<>();
			for (int[] e : prerequisites) {
				if (!edges.containsKey(e[0])) {
					edges.put(e[0], new ArrayList<>());
				}
				edges.get(e[0]).add(e[1]);
			}

			int[] colors = new int[numCourses];

			for (int i = 0; i < colors.length; i++) {
				if (colors[i] == 0) {
					if (dfs(colors, edges, i)) {
						return false;
					}
				}
			}

			return true;
		}

		private boolean dfs(int[] colors, Map<Integer, List<Integer>> edges, int curr) {
			if (colors[curr] > 0) {
				return colors[curr] != 2;
			}
			colors[curr] = 1;
			for (Integer next : edges.getOrDefault(curr, Collections.emptyList())) {
				if (dfs(colors, edges, next)) {
					return true;
				}
			}
			colors[curr] = 2;
			return false;
		}
	}

}
