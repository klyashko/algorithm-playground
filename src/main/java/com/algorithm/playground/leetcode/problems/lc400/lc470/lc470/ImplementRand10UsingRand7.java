package com.algorithm.playground.leetcode.problems.lc400.lc470.lc470;

import java.util.Random;

/**
 * https://leetcode.com/problems/implement-rand10-using-rand7/description/
 */
public class ImplementRand10UsingRand7 {

	/**
	 * The rand7() API is already defined in the parent class SolBase.
	 * public int rand7();
	 * returns a random integer in the range 1 to 7
	 */
	class Solution extends SolBase {

		private int curr = 0;

		public int rand10() {
			curr = ((curr + rand7()) % 10) + 1;
			return curr;
		}
	}

	private class SolBase {

		int rand7() {
			return new Random().nextInt(9) + 1;
		}

	}

}
