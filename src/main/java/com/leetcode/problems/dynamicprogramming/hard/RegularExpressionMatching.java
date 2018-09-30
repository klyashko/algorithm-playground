package com.leetcode.problems.dynamicprogramming.hard;

/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 */
public class RegularExpressionMatching {

    class Solution {

        public boolean isMatch(String str, String pattern) {
            boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
            dp[0][0] = true;

            for (int i = 1; i <= pattern.length(); i++) {
                if (pattern.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }

            for (int i = 1; i <= str.length(); i++) {
                for (int j = 1; j <= pattern.length(); j++) {
                    if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pattern.charAt(j - 1) == '*') {
                        if (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[str.length()][pattern.length()];
        }
    }

}
