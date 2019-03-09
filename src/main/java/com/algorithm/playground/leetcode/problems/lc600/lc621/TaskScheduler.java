package com.algorithm.playground.leetcode.problems.lc600.lc621;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 */
public class TaskScheduler {

	class Solution {
		public int leastInterval(char[] tasks, int n) {
			int[] counts = new int[26];
			int[] wait = new int[26];
			for (char ch : tasks) {
				counts[ch - 'A']++;
			}

			int todo = tasks.length;
			int count = 0;

			while (todo > 0) {
				count++;
				int max = -1;
				for (int i = 0; i < wait.length; i++) {
					if ((max == -1 || counts[max] < counts[i]) && counts[i] != 0 && wait[i] == 0) {
						max = i;
					}
					wait[i] = Math.max(wait[i] - 1, 0);
				}
				if (max != -1) {
					todo--;
					counts[max]--;
					wait[max] = n;
				}
			}

			return count;
		}
	}

}
