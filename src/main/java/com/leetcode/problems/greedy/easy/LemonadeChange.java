package com.leetcode.problems.greedy.easy;

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
				}
				int change = bill - 5;
				while (change > 0) {
					if (change >= 10 && ten > 0) {
						change -= 10;
						ten--;
					} else {
						five -= change / 5;
						change = 0;
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
