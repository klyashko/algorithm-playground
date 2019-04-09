package com.algorithm.playground.leetcode.problems.lc300.lc330.lc336;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-pairs/description/
 */
@SuppressWarnings("Duplicates")
public class PalindromePairs {

	class Solution {

		public List<List<Integer>> palindromePairs(String[] words) {
			Set<List<Integer>> result = new HashSet<>();

			Map<String, Integer> map = new HashMap<>();

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < words.length; i++) {
				map.put(words[i], i);
				min = Math.min(min, words[i].length());
			}

			for (int i = 0; i < words.length; i++) {
				if (words[i].isEmpty()) {
					for (String key : map.keySet()) {
						int idx = map.get(key);
						if (idx != i) {
							if (isPalindrome(key)) {
								result.add(Arrays.asList(idx, i));
							}
						}
					}
				} else {
					if (map.containsKey("") && (isPalindrome(words[i]))) {
						result.add(Arrays.asList(map.get(""), i));
					}
					StringBuilder w = new StringBuilder(words[i]).reverse();
					for (int j = min; j <= w.length(); j++) {
						if (isPalindrome(w.substring(j))) {
							Integer idx = map.get(w.substring(0, j));
							if (idx != null && idx != i) {
								result.add(Arrays.asList(idx, i));
							}
						}
						if (isPalindrome(w.substring(0, j - min))) {
							Integer idx = map.get(w.substring(j - min));
							if (idx != null && idx != i) {
								result.add(Arrays.asList(i, idx));
							}
						}
					}
				}
			}

			return new ArrayList<>(result);
		}

		private boolean isPalindrome(String w) {
			int middle = w.length() / 2;
			int i = w.length() % 2 == 0 ? middle - 1 : middle;
			int j = middle;
			while (i <= j && i >= 0 && j < w.length()) {
				if (w.charAt(i--) != w.charAt(j++)) {
					return false;
				}
			}
			return true;
		}

	}

	class ExampleSolution {

		public List<List<Integer>> palindromePairs(String[] words) {
			List<List<Integer>> result = new ArrayList<>();

			Node root = new Node();

			for (int i = 0; i < words.length; i++) {
				add(root, words[i], i);
			}

			for (int i = 0; i < words.length; i++) {
				search(words[i], i, root, result);
			}

			return result;
		}

		private void search(String w, int i, Node root, List<List<Integer>> list) {
			for (int j = 0; j < w.length(); j++) {
				if (root.idx >= 0 && root.idx != i && isPalindrome(w, j, w.length() - 1)) {
					list.add(Arrays.asList(i, root.idx));
				}

				root = root.children[w.charAt(j) - 'a'];
				if (root == null) {
					return;
				}
			}

			for (int j : root.list) {
				if (i != j) {
					list.add(Arrays.asList(i, j));
				}
			}
		}

		private void add(Node root, String w, int idx) {
			for (int i = w.length() - 1; i >= 0; i--) {
				int j = w.charAt(i) - 'a';
				if (root.children[j] == null) {
					root.children[j] = new Node();
				}
				if (isPalindrome(w, 0, i)) {
					root.list.add(idx);
				}
				root = root.children[j];
			}

			root.list.add(idx);
			root.idx = idx;
		}

		private boolean isPalindrome(String w, int i, int j) {
			while (i < j) {
				if (w.charAt(i++) != w.charAt(j--)) {
					return false;
				}
			}
			return true;
		}

		private class Node {
			Node[] children;

			int idx;

			List<Integer> list;

			private Node() {
				children = new Node[26];
				idx = -1;
				list = new ArrayList<>();
			}
		}

	}

}
