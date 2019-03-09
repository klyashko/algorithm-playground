package com.algorithm.playground.leetcode.problems.map.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/hand-of-straights/description/
 */
@SuppressWarnings("ConstantConditions")
public class HandOfStraights {

	class Solution {
		public boolean isNStraightHand(int[] hand, int W) {
			if (hand.length % W != 0) {
				return false;
			}

			Queue<Integer> queue = new PriorityQueue<>();
			Map<Integer, Integer> counts = new HashMap<>();

			for (int n : hand) {
				if (!counts.containsKey(n)) {
					counts.put(n, 1);
					queue.offer(n);
				} else {
					counts.replace(n, counts.get(n) + 1);
				}
			}

			List<Integer> todo = new ArrayList<>();
			Integer prev = null;

			while (!queue.isEmpty()) {
				todo.clear();
				for (int i = 0; i < W; i++) {
					Integer curr = queue.poll();
					if ((queue.isEmpty() && curr == null) || (prev != null && curr != prev + 1)) {
						return false;
					}
					if (counts.get(curr) == 1) {
						counts.remove(curr);
					} else {
						counts.replace(curr, counts.get(curr) - 1);
						todo.add(curr);
					}
					prev = curr;
				}
				prev = null;
				queue.addAll(todo);
			}

			return true;
		}
	}

}
