package com.algorithm.playground.leetcode.problems.lc100.lc130.lc134;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {

	class Solution {
		public int canCompleteCircuit(int[] gas, int[] cost) {
			int sum = 0, idx = 0, curr = 0;
			for (int i = 0; i < gas.length; i++) {
				int diff = gas[i] - cost[i];
				sum += diff;
				curr += diff;
				if (curr < 0) {
					curr = 0;
					idx = i + 1;
				}
			}

			return sum < 0 ? -1 : idx;
		}
	}

}
