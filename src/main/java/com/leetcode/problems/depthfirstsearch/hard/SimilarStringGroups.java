package com.leetcode.problems.depthfirstsearch.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/similar-string-groups/description/
 */
public class SimilarStringGroups {

	class Solution {
		public int numSimilarGroups(String[] A) {
			Set<String> seen = new HashSet<>();
			LinkedList<String> stack = new LinkedList<>();
			int groups = 0;

			for (String s : A) {
				if (seen.contains(s)) {
					continue;
				}
				stack.push(s);
				seen.add(s);
				groups++;

				while (!stack.isEmpty()) {
					String current = stack.pop();
					for (String next : A) {
						if (seen.contains(next)) {
							continue;
						}
						if (test(current, next)) {
							stack.push(next);
							seen.add(next);
						}
					}
				}
			}

			return groups;
		}

		private boolean test(String s1, String s2) {
			List<Integer> diff = new ArrayList<>();
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					diff.add(i);
				}
				if (diff.size() > 2) {
					return false;
				}
			}
			int idx1 = diff.get(0);
			int idx2 = diff.get(1);
			return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
		}

	}

}
