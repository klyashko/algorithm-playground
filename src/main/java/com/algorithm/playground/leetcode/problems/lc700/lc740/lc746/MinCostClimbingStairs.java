package com.algorithm.playground.leetcode.problems.lc700.lc740.lc746;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {

    class Solution {

        public int minCostClimbingStairs(int[] cost) {
            if (cost.length < 2) {
                return 0;
            }

            for (int i = 0; i < cost.length - 2; i++) {
                cost[i + 2] += Math.min(cost[i], cost[i + 1]);
            }

            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }

    }

}
