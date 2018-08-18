package com.leetcode.problems.dynamic.programming.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class MaximumLengthOfPairChain {

    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
            int current = Integer.MIN_VALUE, length = 0;
            for (int[] pair : pairs) {
                if(pair[0] > current){
                    current = pair[1];
                    length++;
                }
            }
            return length;
        }
    }

}
