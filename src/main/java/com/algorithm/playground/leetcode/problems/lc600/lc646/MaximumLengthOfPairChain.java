package com.algorithm.playground.leetcode.problems.lc600.lc646;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class MaximumLengthOfPairChain {

    class SolutionGreedy {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
            int current = Integer.MIN_VALUE, length = 0;
            for (int[] pair : pairs) {
                if (pair[0] > current) {
                    current = pair[1];
                    length++;
                }
            }
            return length;
        }
    }

    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(p -> p[0]));
            int[] dp = new int[pairs.length];
            Arrays.fill(dp, 1);

            for (int i = 1; i < pairs.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int i : dp) {
                max = Math.max(max, i);
            }
            return max;
        }
    }

}
