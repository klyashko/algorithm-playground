package com.leetcode.problems.dynamicprogramming.medium;

/**
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class KeysKeyboard {

    class Solution {
        public int minSteps(int n) {
            int sum = 0;

            for (int i = 2; i < n; i++) {
                while (n % i == 0) {
                    sum += i;
                    n /= i;
                }
            }

            if (n > 1) {
                sum += n;
            }
            return sum;
        }
    }

}
