package com.algorithm.playground.leetcode.problems.sort.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 */
public class ReorganizeString {

	class Solution {
		public String reorganizeString(String S) {
			int[] counts = new int[26];
			int max = 0;
			for (int i = 0; i < S.length(); i++) {
				int idx = S.charAt(i) - 'a';
				counts[idx]++;
				max = Math.max(max, counts[idx]);
			}
			if (max > (S.length() + 1) / 2) {
				return "";
			}
			Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((Integer i) -> counts[i]).reversed());
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] > 0) {
					queue.add(i);
				}
			}
			StringBuilder builder = new StringBuilder();
			int prev = -1;

			while (!queue.isEmpty()) {
				Integer curr = queue.poll();
				//noinspection ConstantConditions
				counts[curr]--;
				builder.append((char) (curr + 'a'));
				if (prev != -1) {
					queue.add(prev);
				}
				prev = counts[curr] > 0 ? curr : -1;
			}
			return builder.toString();
		}
	}

}
