package com.leetcode.problems.hash.table.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
@SuppressWarnings("Duplicates")
public class MinimumWindowSubstring {

	class Solution {
		public String minWindow(String s, String t) {
			Map<Character, Integer> counts = new HashMap<>();

			for (Character ch : t.toCharArray()) {
				int val = counts.getOrDefault(ch, 0) + 1;
				counts.put(ch, val);
			}

			int required = counts.size();
			int formed = 0;
			int[] ans = new int[]{Integer.MAX_VALUE, 0, 0};
			int l = 0;

			Map<Character, Integer> window = new HashMap<>();

			for (int r = 0; r < s.length(); r++) {
				char ch = s.charAt(r);
				int val = window.getOrDefault(ch, 0) + 1;
				window.put(ch, val);

				if (counts.containsKey(ch) && val == counts.get(ch)) {
					formed++;
				}

				while (l <= r && formed == required) {

					if (r - l < ans[0]) {
						ans[0] = r - l;
						ans[1] = l;
						ans[2] = r + 1;
					}

					ch = s.charAt(l);
					val = window.get(ch) - 1;
					window.put(ch, val);

					if (counts.containsKey(ch) && val < counts.get(ch)) {
						formed--;
					}
					l++;
				}
			}

			if (ans[0] != Integer.MAX_VALUE) {
				return s.substring(ans[1], ans[2]);
			}
			return "";
		}
	}

	class SolutionOptimized {
		public String minWindow(String s, String t) {
			Map<Character, Integer> counts = new HashMap<>();

			for (Character ch : t.toCharArray()) {
				int val = counts.getOrDefault(ch, 0) + 1;
				counts.put(ch, val);
			}

			int required = counts.size();
			int formed = 0;
			int[] ans = new int[]{Integer.MAX_VALUE, 0, 0};
			int l = 0;

			StringBuilder builder = new StringBuilder();
			List<Integer> indexes = new ArrayList<>();

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (counts.containsKey(ch)) {
					builder.append(ch);
					indexes.add(i);
				}
			}

			Map<Character, Integer> window = new HashMap<>();

			for (int r = 0; r < builder.length(); r++) {
				char ch = builder.charAt(r);
				int val = window.getOrDefault(ch, 0) + 1;
				window.put(ch, val);

				if (counts.containsKey(ch) && val == counts.get(ch)) {
					formed++;
				}

				while (l <= r && formed == required) {

					if (indexes.get(r) - indexes.get(l) < ans[0]) {
						ans[0] = indexes.get(r) - indexes.get(l);
						ans[1] = indexes.get(l);
						ans[2] = indexes.get(r) + 1;
					}

					ch = builder.charAt(l);
					val = window.get(ch) - 1;
					window.put(ch, val);

					if (counts.containsKey(ch) && val < counts.get(ch)) {
						formed--;
					}
					l++;
				}
			}

			if (ans[0] != Integer.MAX_VALUE) {
				return s.substring(ans[1], ans[2]);
			}
			return "";
		}
	}

}
