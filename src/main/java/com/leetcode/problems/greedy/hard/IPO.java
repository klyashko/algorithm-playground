package com.leetcode.problems.greedy.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/ipo/description/
 */
public class IPO {

	class Solution {
		public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
			Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
			for (int i = 0; i < Profits.length; i++) {
				queue.offer(new int[]{Capital[i], Profits[i]});
			}
			for (int i = 0; i < k && !queue.isEmpty(); i++) {
				int[] curr = queue.poll();
				//noinspection ConstantConditions
				W += curr[1];
			}
			return W;
		}
	}

}
