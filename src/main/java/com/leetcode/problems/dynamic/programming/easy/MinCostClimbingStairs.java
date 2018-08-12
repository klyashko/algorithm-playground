package com.leetcode.problems.dynamic.programming.easy;

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
                int minCost = Math.min(cost[i], cost[i + 1]);
                cost[i + 2] += minCost;
            }

            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }

    }

}
