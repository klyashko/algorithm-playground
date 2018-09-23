package com.leetcode.problems.greedy.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/course-schedule-iii/description/
 */
public class CourseScheduleIII {

	class Solution {
		public int scheduleCourse(int[][] courses) {
			if (courses.length == 0) {
				return 0;
			}
			Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
			for (int[] c : courses) {
				System.out.println(Arrays.toString(c));
			}
			return dfs(courses, 0, courses[0][0], new int[courses.length]);
		}

		private int dfs(int[][] courses, int curr, int day, int[] cache) {
			if (curr == courses.length) {
				return 0;
			} else if (cache[curr] > 0) {
				return cache[curr];
			}
			int max = 1;
//			for (int i = curr + 1; i < courses.length - max + 1; i++) {
			for (int i = curr + 1; i < courses.length; i++) {
				int[] course = courses[i];
				int finish = day + course[0];
				if (finish <= course[1]) {
					max = Math.max(max, dfs(courses, i, finish, cache) + 1);
				}
			}
			cache[curr] = max;
			return max;
		}
	}

}
