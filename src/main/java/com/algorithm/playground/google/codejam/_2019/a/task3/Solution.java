package com.algorithm.playground.google.codejam._2019.a.task3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
		int max = 0;
		for (String word : words) {
			trie.insert(word);
			max = Math.max(max, word.length());
		}
		Set<String> used = new HashSet<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < max; i++) {
			for (String w : words) {
				if (w.length() > i && !used.contains(w)) {
					String suffix = w.substring(i);
					if (!set.contains(suffix)) {
						Set<String> options = trie.search(suffix);
						for (String op : options) {
							if (!op.equals(w) && !used.contains(op)) {
								used.add(w);
								used.add(op);

								set.add(suffix);
								break;
							}
						}
					}
				}
			}
		}
//		System.out.println(used);
//		System.out.println(set);
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
				curr.count++;
				curr = curr.children[idx];
				curr.words.add(word);
			}
			curr.isWord = true;
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public Set<String> search(String word) {
			TrieNode curr = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				char ch = word.charAt(i);
				int idx = ch - 'A';
				if (curr.children[idx] == null) {
					return Collections.emptySet();
				}
				curr = curr.children[idx];
			}
			return curr == null ? Collections.emptySet() : curr.words;
		}

		private class TrieNode {
			TrieNode[] children = new TrieNode[26];
			Set<String> words = new HashSet<>();
			boolean isWord;
			int count = 0;
		}
	}

}
