package com.leetcode.problems.lc600.lc630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/course-schedule-iii/description/
 */
public class CourseScheduleIII {

	class Solution {
		public int scheduleCourse(int[][] courses) {
			Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
			PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
			int time = 0;
			for (int[] c : courses) {
				if (time + c[0] <= c[1]) {
					queue.offer(c[0]);
					time += c[0];
				} else if (!queue.isEmpty() && queue.peek() > c[0]) {
					time += c[0] - queue.poll();
					queue.offer(c[0]);
				}
			}
			return queue.size();
		}
	}

}
