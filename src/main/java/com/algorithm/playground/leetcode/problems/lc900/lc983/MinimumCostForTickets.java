package com.algorithm.playground.leetcode.problems.lc900.lc983;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * <p>
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 * <p>
 * Train tickets are sold in 3 different ways:
 * <p>
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 * <p>
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */
public class MinimumCostForTickets {

	class Solution {
		public int mincostTickets(int[] days, int[] costs) {
			return mincostTickets(days, costs, new int[days.length], 0, -1);
		}

		public int mincostTickets(int[] days, int[] costs, int[] cache, int idx, int until) {
			if (idx == days.length) {
				return 0;
			} else if (days[idx] <= until) {
				return mincostTickets(days, costs, cache, idx + 1, until);
			} else if (cache[idx] == 0) {
				/** day */
				int min = costs[0] + mincostTickets(days, costs, cache, idx + 1, days[idx]);
				/** week */
				min = Math.min(min, costs[1] + mincostTickets(days, costs, cache, idx + 1, days[idx] + 6));
				/** month */
				min = Math.min(min, costs[2] + mincostTickets(days, costs, cache, idx + 1, days[idx] + 29));
				cache[idx] = min;
			}
			return cache[idx];
		}
	}

}
