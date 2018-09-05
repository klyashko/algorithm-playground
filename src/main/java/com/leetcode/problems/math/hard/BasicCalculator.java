package com.leetcode.problems.math.hard;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 */
public class BasicCalculator {

	public static void main(String[] args) {
		String s = "11";
		Pattern p = Pattern.compile("\\d+");
		System.out.println(p.matcher(s).matches());
//		String s = "1     + 1";
//		String s = "(1+(4+5+2)-3)+(6+8)";
//		s.replace("")
//		s = s.replaceAll("\\s+", "");
//
//		String regex = "(?<=[-+*/()])|(?=[-+*/()])";
//
//		System.out.println(Arrays.toString(s.split(regex)));
	}

	class Solution {

		private final Pattern IS_NUMBER = Pattern.compile("\\d+");

		public int calculate(String s) {

			LinkedList<String> stack = new LinkedList<>();
			String[] expression = parse(s);
//			System.out.println(Arrays.toString(expression));

			for (String part : expression) {
				if (IS_NUMBER.matcher(part).matches()) {
					if (stack.size() < 2) {
						stack.push(part);
					} else {
						String op = stack.poll();
						//noinspection ConstantConditions
						if (op.equals("(")) {
							stack.push(op);
							stack.push(part);
						} else {
							//noinspection SingleStatementInBlock,ConstantConditions
							stack.push(calculate(stack.poll(), op, part));
						}
					}
				} else {
					if (part.equals(")")) {
						String arg2 = stack.poll();
						stack.poll();
						String op = stack.poll();
						if ("(".equals(op)) {
							stack.push(op);
							stack.push(arg2);
						} else {
							if (op == null) {
								stack.push(arg2);
							} else {
								stack.push(calculate(stack.poll(), op, arg2));
							}
						}
					} else {
						stack.push(part);
					}
				}
			}

//			System.out.println(stack);

			//noinspection ConstantConditions
			return Integer.valueOf(stack.peek());
		}

		private String calculate(String s1, String op, String s2) {
			Integer i1 = Integer.valueOf(s1);
			Integer i2 = Integer.valueOf(s2);
			Integer result;
			switch (op) {
				case "+":
					result = i1 + i2;
					break;
				case "-":
					result = i1 - i2;
					break;
				default:
					throw new UnsupportedOperationException(String.format("Operation %s is not supported", op));
			}
			return result.toString();
		}

		private String[] parse(String s) {
			s = s.replaceAll("\\s+", "");
			return s.split("(?<=[-+*/()])|(?=[-+*/()])");
		}
	}

}
