package com.algorithm.playground.leetcode.problems.lc200.lc280.lc282;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/description/
 */
public class ExpressionAddOperators {

	class Solution {
		public List<String> addOperators(String num, int target) {
			List<String> result = new ArrayList<>();
			backtracking(result, num, new StringBuilder(), 0, '*', 0, 0, target);
			return result;
		}

		private void backtracking(List<String> result, String nums, StringBuilder expression, int idx, char op, int num, int val, int target) {
			if (idx == nums.length()) {
				if (val == target) {
					result.add(expression.substring(1));
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

				if (idx != 0) {
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

}
