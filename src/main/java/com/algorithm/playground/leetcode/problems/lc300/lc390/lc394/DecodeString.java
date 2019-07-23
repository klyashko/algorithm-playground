package com.algorithm.playground.leetcode.problems.lc300.lc390.lc394;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/decode-string/
 * <p>
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that
 * digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class DecodeString {

	class Solution {

		public String decodeString(String s) {
			LinkedList<Data> stack = new LinkedList<>();
			stack.push(new Data(1));
			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if (Character.isDigit(curr)) {
					int k = 0;
					while (Character.isDigit(s.charAt(i))) {
						k = (k * 10) + (s.charAt(i) - '0');
						i++;
					}
					stack.push(new Data(k));
				} else if (curr == ']') {
					Data data = stack.pop();
					//noinspection ConstantConditions
					stack.peek().append(data.toString());
				} else {
					//noinspection ConstantConditions
					stack.peek().append(curr);
				}
			}
			//noinspection ConstantConditions
			return stack.peek().toString();
		}

		private class Data {
			int k;
			StringBuilder data;

			private Data(int k) {
				this.k = k;
				this.data = new StringBuilder();
			}

			private void append(char ch) {
				data.append(ch);
			}

			private void append(String s) {
				data.append(s);
			}

			public String toString() {
				if (k == 1) {
					return data.toString();
				}
				String str = data.toString();
				data.setLength(0);
				for (int i = 0; i < k; i++) {
					data.append(str);
				}
				return data.toString();
			}

		}
	}

}
