package com.leetcode.problems.breadthfirstsearch.hard;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/k-similar-strings/description/
 */
public class KSimilarStrings {

	class Solution {
		public int kSimilarity(String A, String B) {
			Queue<String> queue = new ArrayDeque<>();
			Set<String> seen = new HashSet<>();
			queue.add(A);
			seen.add(A);

			int steps = -1;

			while (!queue.isEmpty()) {
				int size = queue.size();
				steps++;
				while (size > 0) {
					String curr = queue.poll();
					size--;
					//noinspection ConstantConditions
					if (curr.equals(B)) {
						return steps;
					}
					StringBuilder builder = new StringBuilder(curr);
					for (int i = 0; i < B.length(); i++) {
						char ch = B.charAt(i);
						if (builder.charAt(i) == ch) {
							continue;
						}
						for (int j = i + 1; j < builder.length(); j++) {
							if (builder.charAt(j) != B.charAt(j) && builder.charAt(j) == ch) {
								swap(builder, i, j);
								String s = builder.toString();
								if (seen.add(s)) {
									queue.add(s);
								}
								swap(builder, j, i);
							}
						}
						break;
					}
				}
			}

			return 0;
		}

		private void swap(StringBuilder builder, int i1, int i2) {
			char ch = builder.charAt(i1);
			builder.setCharAt(i1, builder.charAt(i2));
			builder.setCharAt(i2, ch);
		}
	}

}
