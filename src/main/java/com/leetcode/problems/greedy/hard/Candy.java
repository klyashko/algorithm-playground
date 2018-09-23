package com.leetcode.problems.greedy.hard;

/**
 * https://leetcode.com/problems/candy/description/
 */
public class Candy {

	class Solution {
		public int candy(int[] ratings) {
			int curr = 1;
			int[] candies = new int[ratings.length];
			candies[0] = 1;
			for (int i = 1; i < ratings.length; i++) {
				if (ratings[i] > ratings[i - 1]) {
					curr++;
				} else if (ratings[i] == ratings[i - 1]) {
					curr = 1;
				} else {
					curr = 1;
					candies[i] = curr;
					for (int j = i - 1; j >= 0 && ratings[j] > ratings[j + 1] && candies[j] <= candies[j + 1]; j--) {
						curr++;
						candies[j] = curr;
					}
					curr = 1;
				}
				candies[i] = curr;
			}

//			System.out.println(Arrays.toString(candies));
			int count = 0;
			for (int c : candies) {
				count += c;
			}
			return count;
		}
	}

}
