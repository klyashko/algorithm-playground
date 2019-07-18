package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1011;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 * <p>
 * The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 */
public class CapacityToShipPackagesWithinDDays {

	class Solution {
		public int shipWithinDays(int[] weights, int D) {
			int li = 0;
			int ri = Integer.MAX_VALUE;
			while (li < ri) {
				int mid = (ri - li >> 1) + li;
				if (validate(weights, D, mid)) {
					ri = mid;
				} else {
					li = mid + 1;
				}
			}
			return li;
		}

		private boolean validate(int[] weights, int D, int limit) {
			for (int idx = 0, d = 0; d < D; d++) {
				for (int sum = 0; idx < weights.length; idx++) {
					if (sum + weights[idx] > limit) {
						break;
					} else {
						sum += weights[idx];
					}
				}
				if (idx == weights.length) {
					return true;
				}
			}
			return false;
		}
	}

}
