package com.leetcode.problems.map.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/hand-of-straights/description/
 */
public class HandOfStraights {

	class Solution {
		public boolean isNStraightHand(int[] hand, int W) {
			if (hand.length % W != 0) {
				return false;
			}
			Arrays.sort(hand);

			int n = hand.length / W;

			List<Set<Integer>> list = new ArrayList<>();
			for (int i : hand) {
				boolean done = false;
				for (Set<Integer> set : list) {
					if (set.size() < W && set.contains(i - 1) && set.add(i)) {
						done = true;
						break;
					}
				}
				if (done) {
					continue;
				}
				if (list.size() < n) {
					Set<Integer> set = new HashSet<>();
					set.add(i);
					list.add(set);
				} else {
					return false;
				}
			}

			return true;
		}
	}

}
