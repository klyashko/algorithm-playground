package com.leetcode.problems.string.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

	class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> map = new HashMap<>();
			for (String s : strs) {
				String key = key(s);
				if (!map.containsKey(key)) {
					map.put(key, new ArrayList<>());
				}
				map.get(key).add(s);
			}
			return new ArrayList<>(map.values());
		}

		private String key(String s) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			return String.valueOf(chars);
		}
	}

}
