package com.leetcode.problems.stack.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/number-of-atoms/description/
 */
public class NumberOfAtoms {

	class Solution {
		public String countOfAtoms(String formula) {
			Map<String, Integer> counts = new TreeMap<>(count(formula));
			StringBuilder builder = new StringBuilder();
			for (String key : counts.keySet()) {
				builder.append(key);
				Integer count = counts.get(key);
				if (count != 1) {
					builder.append(count);
				}
			}

			return builder.toString();
		}

		public Map<String, Integer> count(String formula) {
			Map<String, Integer> counts = new HashMap<>();
			Map<String, Integer> parts = parse(formula);

			for (String key : parts.keySet()) {
				if (isElement(key)) {
					counts.put(key, counts.getOrDefault(key, 0) + parts.get(key));
				} else {
					Map<String, Integer> tmp = count(key);
					Integer multiplier = parts.get(key);
					for (String k : tmp.keySet()) {
						counts.put(k, counts.getOrDefault(k, 0) + tmp.get(k) * multiplier);
					}
				}
			}
			return counts;
		}

		private Map<String, Integer> parse(String formula) {
			Map<String, Integer> counts = new HashMap<>();
			for (int i = 0; i < formula.length(); ) {
				char ch = formula.charAt(i);
				String el = "";
				Integer count = 1;
				if (Character.isUpperCase(ch)) {
					el = readElement(formula, i);
					i += el.length();
				} else if (ch == '(') {
					el = readBrackets(formula, i);
					i += el.length() + 2;
				}
				String countStr = readCount(formula, i);
				i += countStr.length();
				if (!countStr.isEmpty()) {
					count = Integer.parseInt(countStr);
				}
				counts.put(el, counts.getOrDefault(el, 0) + count);

			}
			return counts;
		}

		private String readElement(String f, int idx) {
			int end = f.length();
			for (int i = idx + 1; i < f.length(); i++) {
				if (!Character.isLowerCase(f.charAt(i))) {
					end = i;
					break;
				}
			}
			return f.substring(idx, end);
		}

		private String readCount(String f, int idx) {
			if (idx == f.length()) {
				return "";
			}
			int end = f.length();
			for (int i = idx; i < f.length(); i++) {
				if (!Character.isDigit(f.charAt(i))) {
					end = i;
					break;
				}
			}
			return f.substring(idx, end);
		}

		private String readBrackets(String f, int idx) {
			int end = f.length();
			int count = 1;
			for (int i = idx + 1; i < f.length(); i++) {
				char ch = f.charAt(i);
				if (ch == '(') {
					count++;
				} else if (ch == ')') {
					count--;
					if (count == 0) {
						end = i;
						break;
					}
				}
			}
			return f.substring(idx + 1, end);
		}

		private boolean isElement(String s) {
			int upper = 0;
			for (char ch : s.toCharArray()) {
				if (Character.isUpperCase(ch)) {
					upper++;
				} else if (Character.isDigit(ch) || ch == '(') {
					return false;
				}
			}
			return upper == 1;
		}

	}

}
