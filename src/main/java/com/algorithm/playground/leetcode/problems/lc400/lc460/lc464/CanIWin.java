package com.algorithm.playground.leetcode.problems.lc400.lc460.lc464;

/**
 * https://leetcode.com/problems/can-i-win/
 * <p>
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * The player who first causes the running total to reach or exceed 100 wins.
 * <p>
 * What if we change the game so that players cannot re-use integers?
 * <p>
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 * <p>
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 * <p>
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 */
public class CanIWin {

	class Solution {

		public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
			int sum = maxChoosableInteger * (1 + maxChoosableInteger) >> 1;
			boolean[] moves = new boolean[maxChoosableInteger];
			Boolean[] cache = new Boolean[1 << maxChoosableInteger];
			return sum >= desiredTotal && move(moves, 0, desiredTotal, cache, 0);
		}

		private boolean move(boolean[] moves, int sum, int target, Boolean[] cache, int state) {
			if (cache[state] != null) {
				return cache[state];
			}
			for (int i = moves.length; i > 0; i--) {
				if (!moves[i - 1]) {
					int curr = sum + i;
					if (curr >= target) {
						cache[state] = true;
						return true;
					} else {
						state |= 1 << (moves.length - i);
						moves[i - 1] = true;
						if (!move(moves, curr, target, cache, state)) {
							state ^= (1 << (moves.length - i));
							cache[state] = true;
							moves[i - 1] = false;
							return true;
						}
						state ^= (1 << (moves.length - i));
						moves[i - 1] = false;
					}

				}
			}
			cache[state] = false;
			return false;
		}

	}

}
