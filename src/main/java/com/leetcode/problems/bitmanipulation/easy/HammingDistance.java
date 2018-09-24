package com.leetcode.problems.bitmanipulation.easy;

/**
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class HammingDistance {

	class Solution {
		public int hammingDistance(int x, int y) {
			int t = x;
			x = Math.min(x, y);
			y = Math.max(t, y);
			StringBuilder str1 = new StringBuilder(Integer.toBinaryString(x));
			String str2 = Integer.toBinaryString(y);

			while (str1.length() < str2.length()) {
				str1.insert(0, "0");
			}

			int count = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					count++;
				}
			}

			return count;
		}
	}

}
