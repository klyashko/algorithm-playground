package com.leetcode.problems.depthfirstsearch.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/similar-string-groups/description/
 */
public class SimilarStringGroups {

	class Solution {
		public int numSimilarGroups(String[] A) {
			Set<String> words = new HashSet<>(Arrays.asList(A));
			LinkedList<String> stack = new LinkedList<>();
			int groups = 0;

			while (!words.isEmpty()) {
				String s = words.iterator().next();
				words.remove(s);
				stack.push(s);
				groups++;

				while (!stack.isEmpty() && !words.isEmpty()) {
					String current = stack.pop();
					List<String> toRemove = new ArrayList<>();
					for (String next : words) {
						if (areSimilar(current, next)) {
							stack.push(next);
							toRemove.add(next);
						}
					}
					words.removeAll(toRemove);
				}
			}

			return groups;
		}

		private boolean areSimilar(String s1, String s2) {
			List<Integer> diff = difference(s1, s2);
			if (diff.size() != 2) {
				return false;
			}
			int idx1 = diff.get(0);
			int idx2 = diff.get(1);
			return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
		}

		private List<Integer> difference(String s1, String s2) {
			List<Integer> diff = new ArrayList<>();
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					diff.add(i);
				}
			}
			return diff;
		}
	}

}
