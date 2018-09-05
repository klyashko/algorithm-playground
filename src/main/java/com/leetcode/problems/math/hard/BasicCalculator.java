package com.leetcode.problems.math.hard;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 */
public class BasicCalculator {

	class Solution {

		private final Pattern IS_NUMBER = Pattern.compile("\\d+");

		public int calculate(String s) {

			LinkedList<Integer> numbers = new LinkedList<>();
			LinkedList<String> ops = new LinkedList<>();
			String[] expression = parse(s);

			for (String part : expression) {
				if (IS_NUMBER.matcher(part).matches()) {
					numbers.push(Integer.valueOf(part));
				} else {
					if (")".equals(part)) {
						ops.poll();
					} else {
						ops.push(part);
						continue;
					}
				}
				if (numbers.size() > 1 && !"(".equals(ops.peek())) {
					Integer arg2 = numbers.poll();
					//noinspection ConstantConditions
					numbers.push(calculate(numbers.poll(), ops.poll(), arg2));
				}
			}

			//noinspection ConstantConditions
			return numbers.poll();
		}

		private Integer calculate(Integer i1, String op, Integer i2) {
			switch (op) {
				case "+":
					return i1 + i2;
				case "-":
					return i1 - i2;
				default:
					throw new UnsupportedOperationException(String.format("Operation %s is not supported", op));
			}
		}

		private String[] parse(String s) {
			s = s.replaceAll("\\s+", "");
			return s.split("(?<=[-+*/()])|(?=[-+*/()])");
		}
	}

	class SolutionFast {

		public int calculate(String s) {

			LinkedList<Integer> numbers = new LinkedList<>();
			LinkedList<Character> ops = new LinkedList<>();

			for (int i = 0; i < s.length(); i++) {
				char part = s.charAt(i);
				if (' ' == part) {
					continue;
				}
				if (Character.isDigit(part)) {
					int ii = part - '0';
					while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
						ii = ii * 10 + (s.charAt(i + 1) - '0');
						i++;
					}
					numbers.push(ii);
				} else {
					if (')' == part) {
						ops.poll();
					} else {
						ops.push(part);
						continue;
					}
				}
				//noinspection ConstantConditions
				if (numbers.size() > 1 && !('(' == ops.peek())) {
					Integer arg2 = numbers.poll();
					//noinspection ConstantConditions
					numbers.push(calculate(numbers.poll(), ops.poll(), arg2));
				}
			}

			//noinspection ConstantConditions
			return numbers.poll();
		}

		private Integer calculate(Integer i1, Character op, Integer i2) {
			switch (op) {
				case '+':
					return i1 + i2;
				case '-':
					return i1 - i2;
				default:
					throw new UnsupportedOperationException(String.format("Operation %s is not supported", op));
			}
		}

	}

}
