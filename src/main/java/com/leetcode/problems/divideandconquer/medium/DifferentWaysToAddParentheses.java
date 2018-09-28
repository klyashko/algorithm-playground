package com.leetcode.problems.divideandconquer.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 */
public class DifferentWaysToAddParentheses {

	class Solution {
		public List<Integer> diffWaysToCompute(String input) {
			List<Integer> numbers = new ArrayList<>();
			List<Character> operations = new ArrayList<>();
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (Character.isDigit(ch)) {
					StringBuilder num = new StringBuilder();
					num.append(ch);
					for (int j = i + 1; j < input.length(); j++) {
						char next = input.charAt(j);
						if (!Character.isDigit(next)) {
							break;
						}
						num.append(next);
						i = j;
					}
					numbers.add(Integer.valueOf(num.toString()));
				} else {
					operations.add(ch);
				}
			}
			if (operations.isEmpty()) {
				return numbers;
			}

			Map<Integer, Map<Integer, List<Integer>>> cache = new HashMap<>();
			return calc(numbers, operations, cache, 0, numbers.size() - 1);
		}

		private List<Integer> calc(List<Integer> numbers, List<Character> operations, Map<Integer, Map<Integer, List<Integer>>> cache, int li, int ri) {
//			System.out.println("li=" + li + " ri=" + ri);
			if (li == ri) {
				return Collections.singletonList(numbers.get(li));
			} else if (cache.containsKey(li) && cache.get(li).containsKey(ri)) {
				return cache.get(li).get(ri);
			}
			List<Integer> result = new ArrayList<>();
			for (int i = li; i < ri; i++) {
				List<Integer> left = calc(numbers, operations, cache, li, i);
				List<Integer> right = calc(numbers, operations, cache, i + 1, ri);
				for (Integer i1 : left) {
					for (Integer i2 : right) {
						result.add(calc(i1, i2, operations.get(i)));
					}
				}
			}
			if (!cache.containsKey(li)) {
				cache.put(li, new HashMap<>());
			}
			cache.get(li).put(ri, result);

			return result;
		}

		private Integer calc(Integer i1, Integer i2, Character op) {
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
