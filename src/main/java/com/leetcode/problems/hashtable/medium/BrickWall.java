package com.leetcode.problems.hashtable.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/brick-wall/
 */
public class BrickWall {

	class Solution {
		public int leastBricks(List<List<Integer>> wall) {
			Map<Integer, Integer> row = new HashMap<>();
			int max = 0;
			for (List<Integer> curr : wall) {
				Integer sum = 0;
				for (int i = 0; i < curr.size() - 1; i++) {
					sum += curr.get(i);
					row.put(sum, row.getOrDefault(sum, 0) + 1);
					max = Math.max(max, row.get(sum));
				}
			}
			return wall.size() - max;
		}
	}

}
