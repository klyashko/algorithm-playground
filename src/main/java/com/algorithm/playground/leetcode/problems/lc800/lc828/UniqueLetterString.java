package com.algorithm.playground.leetcode.problems.lc800.lc828;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-letter-string/description/
 */
public class UniqueLetterString {

	class Solution {
		public int uniqueLetterString(String S) {
			Map<Character, List<Integer>> index = new HashMap<>();
			for (int i = 0; i < S.length(); ++i) {
				char c = S.charAt(i);
				if (!index.containsKey(c)) {
					index.put(c, new ArrayList<>());
				}
				index.get(c).add(i);
			}

			long ans = 0;
			for (List<Integer> A : index.values()) {
				for (int i = 0; i < A.size(); ++i) {
					long prev = i > 0 ? A.get(i - 1) : -1;
					long next = i < A.size() - 1 ? A.get(i + 1) : S.length();
					ans += (A.get(i) - prev) * (next - A.get(i));
				}
			}

			return (int) ans % 1_000_000_007;
		}
	}

}
