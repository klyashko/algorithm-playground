package com.algorithm.playground.leetcode.problems.lc100.lc130.lc134;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

	class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int[] diff = new int[gas.length];
			int[][] indexes = new int[diff.length][1];
			for (int i = 0; i < gas.length; i++) {
				diff[i] = gas[i] - cost[i];
				indexes[i][0] = i;
			}

			Arrays.sort(indexes, Comparator.comparingInt((int[] i) -> diff[i[0]]).reversed());

			for (int[] index : indexes) {
				int start = index[0];
				if (diff[start] < 0) {
					return -1;
				}
				int curr = diff[start];
				for (int idx = (start + 1) % gas.length; idx != start; idx = (idx + 1) % gas.length) {
					if (curr < 0) {
						break;
					}
					curr += diff[idx];
				}
				if (curr >= 0) {
					return start;
				}
			}

			return -1;
		}
	}

}
