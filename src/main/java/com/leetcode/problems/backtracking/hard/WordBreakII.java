package com.leetcode.problems.backtracking.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreakII {

	class Solution {
		public List<String> wordBreak(String s, List<String> wordDict) {
			List<String> result = new ArrayList<>();
			backtracking(s, wordDict, new ArrayList<>(), result);
			return result;
		}

		private void backtracking(String s, List<String> words, List<String> current, List<String> result) {
			if (s.isEmpty()) {
				result.add(String.join(" ", current));
				return;
			}
			for (String w : words) {
				if (s.startsWith(w)) {
					current.add(w);
					backtracking(s.substring(w.length()), words, current, result);
					current.remove(current.size() - 1);
				}
			}
		}
	}

}
