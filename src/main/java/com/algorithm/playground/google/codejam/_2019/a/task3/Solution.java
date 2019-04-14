package com.algorithm.playground.google.codejam._2019.a.task3;

import java.util.*;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e05
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				String[] words = new String[n];
				for (int i = 0; i < words.length; i++) {
					words[i] = console.next().trim();
				}
				int ans = solve(words);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(String[] words) {
		Trie trie = new Trie();
		Queue<Pair> pairs = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.suffix.length()).reversed());
		for (String word : words) {
			pairs.addAll(trie.search(word));
			trie.insert(word);
		}

		Set<String> used = new HashSet<>();
		Set<String> suffixes = new HashSet<>();
		while (!pairs.isEmpty()) {
			Pair curr = pairs.poll();
			if (!used.contains(curr.word1) && !used.contains(curr.word2)) {
				if (suffixes.contains(curr.suffix)) {
					String suffix = curr.suffix.substring(1);
					while (!suffix.isEmpty() && suffixes.contains(suffix)) {
						suffix = suffix.substring(1);
					}
					if (!suffix.isEmpty()) {
						pairs.offer(new Pair(curr.word1, curr.word2, suffix));
					}
				} else {
					used.add(curr.word1);
					used.add(curr.word2);

					suffixes.add(curr.suffix);
				}
			}
		}

		return used.size();
	}

	private static class Trie {

		private TrieNode root = new TrieNode();

		/**
		 * Initialize your data structure here.
		 */
		private Trie() { }

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			TrieNode curr = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				char ch = word.charAt(i);
				int idx = ch - 'A';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode();
				}
				curr = curr.children[idx];
			}
			curr.word = word;
		}

		public Set<Pair> search(String word) {
			Set<Pair> pairs = new HashSet<>();
			StringBuilder suffix = new StringBuilder();
			int idx = word.length() - 1;
			char ch = word.charAt(idx);
			TrieNode node = root.children[ch - 'A'];

			suffix.append(ch);

			search(node, word, suffix, pairs, idx - 1, false);
			return pairs;
		}

		/**
		 * Returns if the word is in the trie.
		 */
		private void search(TrieNode node, String word, StringBuilder suffix, Set<Pair> pairs, int idx, boolean closed) {
			if (node != null) {
				if (node.word != null) {
					pairs.add(new Pair(word, node.word, suffix.toString()));
				}
				if (!closed && idx >= 0) {
					char ch = word.charAt(idx);
					for (int i = 0; i < node.children.length; i++) {
						TrieNode next = node.children[i];
						char val = (char) (i + 'A');
						if (ch == val) {
							suffix.insert(0, val);
							search(next, word, suffix, pairs, idx - 1, false);
							suffix.deleteCharAt(0);
						} else {
							search(next, word, suffix, pairs, idx, true);
						}
					}
				} else {
					for (TrieNode next : node.children) {
						search(next, word, suffix, pairs, idx, true);
					}
				}
			}
		}

		private class TrieNode {
			TrieNode[] children = new TrieNode[26];
			String word;
		}

	}

	private static class Pair {

		private String word1;
		private String word2;
		private String suffix;

		private Pair(String word1, String word2, String suffix) {
			this.word1 = word1;
			this.word2 = word2;
			this.suffix = suffix;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"word1='" + word1 + '\'' +
					", word2='" + word2 + '\'' +
					", suffix='" + suffix + '\'' +
					'}';
		}
	}

}
