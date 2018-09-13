package com.leetcode.problems.twopointers.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/description/
 */
public class PartitionLabels {

	class Solution {
		public List<Integer> partitionLabels(String S) {
			int[] positions = new int[26];
			for (int i = 0; i < S.length(); i++) {
				int idx = S.charAt(i) - 'a';
				positions[idx] = i;
			}
			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < S.length(); i++) {
				int until = positions[S.charAt(i) - 'a'];
				while (i <= until) {
					until = Math.max(until, positions[S.charAt(i++) - 'a']);
				}
				result.add(i--);
			}
			for (int i = result.size() - 1; i > 0; i--) {
				result.set(i, result.get(i) - result.get(i - 1));
			}
			return result;
		}
	}

}
