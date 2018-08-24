package com.leetcode.problems.string.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/custom-sort-string/description/
 */
public class CustomSortString {

	class SolutionStream {
		public String customSortString(String S, String T) {
			int[] weights = new int[26];

			Arrays.fill(weights, Integer.MAX_VALUE);

			for (int i = 0; i < S.length(); i++) {
				int idx = S.charAt(i) - 97;
				weights[idx] = i;
			}

			StringBuilder builder = new StringBuilder();
			T.chars()
				.boxed()
				.sorted(Comparator.comparingInt(ch -> weights[ch - 97]))
				.forEach(i -> builder.append(Character.toChars(i)));

			return builder.toString();
		}
	}

	class Solution {
		public String customSortString(String S, String T) {
			boolean[] isInPattern = new boolean[26];
			int[] counts = new int[26];

			for (int i = 0; i < T.length(); i++) {
				int idx = T.charAt(i) - 97;
				counts[idx]++;
			}

			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < S.length(); i++) {
				char ch = S.charAt(i);
				int idx = ch - 97;
				isInPattern[idx] = true;

				for (int j = counts[idx]; j > 0; j--) {
					builder.append(ch);
				}
			}

			for (int i = 0; i < T.length(); i++) {
				char ch = T.charAt(i);
				int idx = ch - 97;
				if (!isInPattern[idx]) {
					builder.append(ch);
				}
				counts[idx]++;
			}

			return builder.toString();
		}
	}

}
