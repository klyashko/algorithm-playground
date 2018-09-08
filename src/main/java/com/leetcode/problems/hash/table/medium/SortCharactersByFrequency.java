package com.leetcode.problems.hash.table.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class SortCharactersByFrequency {

	class Solution {
		public String frequencySort(String s) {
			Map<Character, Integer> map = new HashMap<>();
			char[] chars = s.toCharArray();
			for (char ch : chars) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}

			StringBuilder[] buckets = new StringBuilder[chars.length + 1];
			for (char ch : map.keySet()) {
				int idx = map.get(ch);
				if (buckets[idx] == null) {
					buckets[idx] = new StringBuilder();
				}
				buckets[idx].append(ch);
			}

			StringBuilder builder = new StringBuilder();

			for (int i = buckets.length - 1; i > 0; i--) {
				if (buckets[i] == null) {
					continue;
				}
				for (int j = 0; j < buckets[i].length(); j++) {
					for (int g = 0; g < i; g++) {
						builder.append(buckets[i].charAt(j));
					}
				}
			}

			return builder.toString();
		}
	}

	class Solution_ {
		public String frequencySort(String s) {
			Map<Character, Integer> map = new HashMap<>();
			char[] chars = s.toCharArray();
			for (char ch : chars) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}

			Character[] characters = map.keySet().toArray(new Character[0]);
			Arrays.sort(characters, Comparator.comparingInt((ToIntFunction<Character>) map::get).reversed());
			StringBuilder builder = new StringBuilder();
			for (char ch : characters) {
				for (int i = 0; i < map.get(ch); i++) {
					builder.append(ch);
				}
			}

			return builder.toString();
		}
	}

}
