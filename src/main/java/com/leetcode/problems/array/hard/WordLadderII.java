package com.leetcode.problems.array.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 */
public class WordLadderII {

	public class Solution {
		public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
			if (!wordList.contains(endWord)) {
				return Collections.emptyList();
			}
			Map<String, List<String>> options = new HashMap<>();
			options.put(beginWord, findAllSimilar(beginWord, wordList));
			for (String word : wordList) {
				if (!word.equals(endWord)) {
					options.put(word, findAllSimilar(word, wordList));
				}
			}

			int depth = findDepth(beginWord, endWord, options);
			if (depth == Integer.MAX_VALUE) {
				return Collections.emptyList();
			}
			LinkedList<String> stack = new LinkedList<>();
			stack.addLast(beginWord);
			int[] visited = new int[wordList.size()];
			Arrays.fill(visited, Integer.MAX_VALUE);

			List<List<String>> result = new ArrayList<>();
			depthFirst(stack, depth, options, result, endWord, visited, wordList);
			return result;
		}

		private void depthFirst(LinkedList<String> stack,
								int depth,
								Map<String, List<String>> options,
								List<List<String>> result,
								String endWord,
								int[] visited,
								List<String> wordList) {
			if (stack.isEmpty()) {
				return;
			}
			String current = stack.peekLast();
			if (stack.size() + 1 == depth) {
				if (options.get(current).contains(endWord)) {
					List<String> way = new ArrayList<>(stack);
					way.add(endWord);
					result.add(way);
				}
			} else if (stack.size() + 1 < depth) {
				for (String next : options.get(current)) {
					int idx = wordList.indexOf(next);
					if (idx == -1 || visited[idx] > stack.size()) {
						visited[idx] = stack.size();
						stack.addLast(next);
						depthFirst(stack, depth, options, result, endWord, visited, wordList);
					}
				}
			}
			int idx = wordList.indexOf(current);
			if (idx != -1) {
				visited[idx] = stack.size();
			}
			stack.pollLast();
		}

		private int findDepth(String current, String end, Map<String, List<String>> options) {
			Set<String> visited = new HashSet<>();
			Set<String> next = new HashSet<>();
			next.add(current);

			int i = 1;
			for (; !next.contains(end); i++) {
				Set<String> tmp = new HashSet<>();
				for (String key : next) {
					if (!visited.contains(key)) {
						tmp.addAll(options.getOrDefault(key, Collections.emptyList()));
						visited.add(key);
					}
				}
				next.clear();
				next.addAll(tmp);
				if (i > options.size()) {
					return Integer.MAX_VALUE;
				}
			}
			return i;
		}

		private List<String> findAllSimilar(String word, List<String> wordList) {
			List<String> list = new ArrayList<>();
			for (String option : wordList) {
				if (option.equals(word)) {
					continue;
				}
				boolean diff = false;
				boolean add = true;
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) != option.charAt(i)) {
						if (diff) {
							add = false;
							break;
						} else {
							diff = true;
						}
					}
				}
				if (add) {
					list.add(option);
				}
			}
			return list;
		}
	}

}
