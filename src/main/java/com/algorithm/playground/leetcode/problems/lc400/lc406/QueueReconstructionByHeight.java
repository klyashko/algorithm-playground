package com.algorithm.playground.leetcode.problems.lc400.lc406;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 */
public class QueueReconstructionByHeight {

	class Solution {
		public int[][] reconstructQueue(int[][] people) {
			Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p2[0], p1[0]));
			LinkedList<int[]> list = new LinkedList<>();
			for (int[] p : people) {
				list.add(p[1], p);
			}
			return list.toArray(new int[0][]);
		}
	}

}
