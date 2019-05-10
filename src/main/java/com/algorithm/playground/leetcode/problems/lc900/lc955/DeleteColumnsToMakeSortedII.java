package com.algorithm.playground.leetcode.problems.lc900.lc955;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class DeleteColumnsToMakeSortedII {

	class Solution {
		public int minDeletionSize(String[] A) {
			int len = A[0].length(), count = 0;
			char[][] chars = new char[A.length][len];
			for (int i = 0; i < len; i++) {
				boolean delete = false;
				int same = 0;
				for (int j = 1; j < A.length && !delete; j++) {
					String s1 = A[j - 1];
					String s2 = A[j];
					if (Arrays.equals(chars[j - 1], chars[j])) {
						delete = s2.charAt(i) < s1.charAt(i);
						same += s2.charAt(i) == s1.charAt(i) ? 1 : 0;
					}
				}
				if (delete) {
					count++;
				} else if (same == 0) {
					break;
				} else {
					for (int j = 0; j < A.length; j++) {
						chars[j][i] = A[j].charAt(i);
					}
				}
			}
			return count;
		}
	}

}
