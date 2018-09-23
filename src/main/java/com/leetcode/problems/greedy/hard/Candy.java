package com.leetcode.problems.greedy.hard;

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
					candies[i] = 1;
					for (int j = i - 1; j >= 0 && ratings[j] > ratings[j + 1] && candies[j] <= candies[j + 1]; j--) {
						candies[j] = candies[j + 1] + 1;
					}
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
