package com.leetcode.problems.divideandconquer.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/description/
 */
public class ExpressionAddOperators {

	class Solution {
		public List<String> addOperators(String num, int target) {
			List<String> result = new ArrayList<>();
			if (num == null || num.isEmpty()) {
				return result;
			}
			int offset = Long.valueOf(num.substring(0, Math.min(10, num.length()))) <= Integer.MAX_VALUE ? 10 : 9;
			int until = num.charAt(0) == '0' ? 1 : Math.min(offset, num.length());
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < until; i++) {
				Integer n = Integer.valueOf(num.substring(0, i + 1));
				builder.append(n);
				backtracking(result, num, builder, i + 1, '+', n, n, target);
				builder.setLength(0);
			}
			return result;
		}

		private void backtracking(List<String> result, String nums, StringBuilder expression, int idx, char op, int num, int val, int target) {
			if (idx == nums.length()) {
				if (val == target) {
					result.add(expression.toString());
				}
				return;
			}
			int len = expression.length();
			int offset = Long.valueOf(nums.substring(idx, Math.min(idx + 10, nums.length()))) <= Integer.MAX_VALUE ? 10 : 9;
			int until = nums.charAt(idx) == '0' ? idx + 1 : Math.min(nums.length(), idx + offset);
			for (int i = idx; i < until; i++) {
				Integer n = Integer.valueOf(nums.substring(idx, i + 1));
				/** + */
				expression.append("+").append(n);
				backtracking(result, nums, expression, i + 1, '+', n, val + n, target);
				expression.setLength(len);

				/** - */
				expression.append("-").append(n);
				backtracking(result, nums, expression, i + 1, '-', n, val - n, target);
				expression.setLength(len);

				/** * */
				expression.append("*").append(n);
				int tmp = val;
				if (op == '+') {
					tmp -= num;
					tmp += num * n;
					backtracking(result, nums, expression, i + 1, '+', num * n, tmp, target);
				} else if (op == '-') {
					tmp += num;
					tmp -= num * n;
					backtracking(result, nums, expression, i + 1, '-', num * n, tmp, target);
				}
				expression.setLength(len);
			}
		}

	}

}
