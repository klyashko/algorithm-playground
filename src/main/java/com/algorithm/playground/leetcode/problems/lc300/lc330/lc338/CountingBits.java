package com.algorithm.playground.leetcode.problems.lc300.lc330.lc338;

/**
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {

    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                //res[i] = res[i / 2] + i % 2
                res[i] = res[i >> 1] + (i & 1);
            }
            return res;
        }
    }

}
