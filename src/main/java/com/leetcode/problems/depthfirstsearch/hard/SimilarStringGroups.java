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
				stack.push(s);
				words.remove(s);
				groups++;

				while (!stack.isEmpty()) {
					String current = stack.pop();
					Iterator<String> iterator = words.iterator();
					while (iterator.hasNext()) {
						String next = iterator.next();
						if (test(current, next)) {
							stack.push(next);
							iterator.remove();
						}
					}
				}
			}

			return groups;
		}

		private boolean test(String s1, String s2) {
			int[] diff = new int[]{-1, -1};
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					if (!put(diff, 0, i) && !put(diff, 1, i)) {
						return false;
					}
				}
			}
			int idx1 = diff[0];
			int idx2 = diff[1];
			return idx2 != -1 && s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
		}

		@SuppressWarnings("BooleanMethodIsAlwaysInverted")
		private boolean put(int[] diff, int idx, int val) {
			if (diff[idx] != -1) {
				return false;
			}
			diff[idx] = val;
			return true;
		}

	}

}
