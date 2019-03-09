package com.algorithm.playground.leetcode.problems.dynamicprogramming.medium;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 */
public class CountNumbersWithUniqueDigits {

    class SolutionRecursive {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            int options = 9;
            for (int i = 1; i < n; i++) {
                options *= (10 - i);
            }
            return options + countNumbersWithUniqueDigits(n - 1);
        }
    }

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            int dp = 9;
            int sum = 10;
            for (int i = 1; i < n; i++) {
                dp = dp * (10 - i);
                sum += dp;
            }
            return sum;
        }
    }

}
