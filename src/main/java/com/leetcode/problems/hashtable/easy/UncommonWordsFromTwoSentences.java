package com.leetcode.problems.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 */
public class UncommonWordsFromTwoSentences {

	class Solution {
		public String[] uncommonFromSentences(String A, String B) {
			Set<String> seen = new HashSet<>();
			Set<String> result = new HashSet<>();
			String s = A + " " + B;

			for (String w : s.split(" ")) {
				if (seen.add(w)) {
					result.add(w);
				} else {
					result.remove(w);
				}
			}
			return result.toArray(new String[0]);
		}
	}

}
