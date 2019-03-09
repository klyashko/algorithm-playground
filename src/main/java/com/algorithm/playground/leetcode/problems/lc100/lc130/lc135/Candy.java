package com.algorithm.playground.leetcode.problems.lc100.lc130.lc135;

/**
 * https://leetcode.com/problems/candy/description/
 */
public class Candy {

	class Solution {
		public int candy(int[] ratings) {
			int[] candies = new int[ratings.length];
			candies[0] = 1;
			for (int i = 1; i < ratings.length; i++) {
				if (ratings[i] > ratings[i - 1]) {
					candies[i] = candies[i - 1] + 1;
				} else if (ratings[i] == ratings[i - 1]) {
					candies[i] = 1;
				} else {
					int c = 1;
					for (int j = i; j < ratings.length && ratings[j] < ratings[j - 1]; j++) {
						c++;
					}
					candies[i - 1] = Math.max(c, candies[i - 1]);
					int tmp = c - 1;
					for (int j = i; j < i + c - 1; j++) {
						candies[j] = tmp--;
					}
					i = i + c - 2;
				}
			}

			int count = 0;
			for (int c : candies) {
				count += c;
			}
			return count;
		}
	}

}
