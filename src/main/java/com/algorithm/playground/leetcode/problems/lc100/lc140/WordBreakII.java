package com.algorithm.playground.leetcode.problems.lc100.lc140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreakII {

	class Solution {
		public List<String> wordBreak(String s, List<String> wordDict) {
			List<String> result = new ArrayList<>();
			backtracking(s, filter(s, wordDict), new ArrayList<>(), result, new HashSet<>());
			return result;
		}

		private List<String> filter(String s, List<String> words) {
			List<String> list = new ArrayList<>();
			for (String w : words) {
				if (s.contains(w)) {
					list.add(w);
				}
			}
			return list;
		}

		private void backtracking(String s, List<String> words, List<String> current, List<String> result, Set<String> invalid) {
			if (s.isEmpty()) {
				result.add(String.join(" ", current));
			} else if (!invalid.contains(s)) {
				for (String w : words) {
					if (s.startsWith(w)) {
						current.add(w);
						String tmp = s.substring(w.length());
						int size = result.size();
						backtracking(tmp, words, current, result, invalid);
						if (result.size() == size) {
							invalid.add(tmp);
						}
						current.remove(current.size() - 1);
					}
				}
			}
		}
	}

}
