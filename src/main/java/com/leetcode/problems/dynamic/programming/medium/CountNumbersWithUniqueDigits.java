package com.leetcode.problems.dynamic.programming.medium;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 */
public class CountNumbersWithUniqueDigits {

    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 10;
            }
            int options = 9;
            for (int i = 1; i < n; i++) {
                options *= (10 - i);
            }
            return options + countNumbersWithUniqueDigits(n - 1);
        }
    }

}
