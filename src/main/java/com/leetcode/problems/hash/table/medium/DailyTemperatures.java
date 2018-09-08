package com.leetcode.problems.hash.table.medium;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class DailyTemperatures {

	class Solution {
		public int[] dailyTemperatures(int[] T) {
			int[] ans = new int[T.length];
			LinkedList<Integer> stack = new LinkedList<>();
			for (int i = T.length - 1; i >= 0; i--) {
				//noinspection ConstantConditions
				while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
					stack.pop();
				}
				ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
				stack.push(i);
			}

			return ans;
		}
	}

	class Solution_ {
		public int[] dailyTemperatures(int[] temperatures) {
			int[] ans = new int[temperatures.length];

			for (int i = 0; i < temperatures.length; i++) {
				for (int j = i + 1; j < temperatures.length; j++) {
					if (temperatures[i] < temperatures[j]) {
						ans[i] = j - i;
						break;
					}
				}
			}

			return ans;
		}
	}

}
