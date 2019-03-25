package com.algorithm.playground.leetcode.problems.lc800.lc860.lc860;

/**
 * https://leetcode.com/problems/lemonade-change/description/
 */
public class LemonadeChange {

	class Solution {
		public boolean lemonadeChange(int[] bills) {
			int five = 0;
			int ten = 0;

			for (int bill : bills) {
				if (bill == 5) {
					five++;
				} else if (bill == 10) {
					ten++;
					five--;
				} else {
					if (ten > 0) {
						ten--;
						five--;
					} else {
						five -= 3;
					}
				}
				if (five < 0) {
					return false;
				}
			}
			return true;
		}
	}

}
