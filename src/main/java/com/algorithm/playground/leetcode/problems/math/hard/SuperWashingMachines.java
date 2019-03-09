package com.algorithm.playground.leetcode.problems.math.hard;

/**
 * https://leetcode.com/problems/super-washing-machines/description/
 */
public class SuperWashingMachines {

	class Solution {
		public int findMinMoves(int[] machines) {
			int sum = 0;
			for (int i : machines) {
				sum += i;
			}
			if (sum % machines.length != 0) {
				return -1;
			}

			int avg = sum / machines.length;
			int ans = 0;
			int[] move = new int[machines.length];
			for (int i = 0; i < machines.length - 1; i++) {
				if (machines[i] > avg) {
					move[i] += machines[i] - avg;
					machines[i + 1] += machines[i] - avg;
					machines[i] = avg;
					ans = Math.max(ans, move[i]);
				} else {
					move[i + 1] = avg - machines[i];
					machines[i + 1] -= avg - machines[i];
					machines[i] = avg;
					ans = Math.max(ans, move[i + 1]);
				}
			}

			return ans;
		}
	}

}
