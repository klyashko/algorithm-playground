package com.algorithm.playground.leetcode.problems.lc200.lc240.lc241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 */
public class DifferentWaysToAddParentheses {

	class Solution {

		private Map<String, List<Integer>> cache = new HashMap<>();

		public List<Integer> diffWaysToCompute(String input) {
			if (cache.containsKey(input)) {
				return cache.get(input);
			}
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (!Character.isDigit(ch)) {
					List<Integer> left = diffWaysToCompute(input.substring(0, i));
					List<Integer> right = diffWaysToCompute(input.substring(i + 1));
					for (Integer i1 : left) {
						for (Integer i2 : right) {
							result.add(calc(i1, i2, ch));
						}
					}
				}
			}
			if (result.size() == 0) {
				result.add(Integer.valueOf(input));
			}
			cache.put(input, result);
			return result;
		}

		private Integer calc(Integer i1, Integer i2, char op) {
			switch (op) {
				case '+':
					return i1 + i2;
				case '-':
					return i1 - i2;
				default:
					return i1 * i2;
			}
		}
	}

}
