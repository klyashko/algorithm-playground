package com.leetcode.problems.dynamic.programming.easy;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 */
public class ClimbingStairs {

    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int i = 1, j = 2;

            for (int x = 3; x <= n; x++) {
                int g = i + j;
                i = j;
                j = g;
            }

            return j;
        }
    }

}
