package com.algorithm.playground.leetcode.problems.backtracking.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 */
@SuppressWarnings("Duplicates")
public class WordSearchII {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public List<String> findWords(char[][] board, String[] words) {
			if (board.length == 0 || words.length == 0) {
				return Collections.emptyList();
			}
			TrieNode root = new TrieNode();
			for (String w : words) {
				insert(root, w);
			}
			int rows = board.length;
			int cols = board[0].length;
			List<String> result = new ArrayList<>();
			boolean[][] visited = new boolean[rows][cols];
			StringBuilder builder = new StringBuilder();
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					dfs(board, root.children, visited, r, c, builder, result);
				}
			}
			return result;
		}

		private void dfs(char[][] board, TrieNode[] children, boolean[][] visited, int r, int c, StringBuilder builder, List<String> result) {
			visited[r][c] = true;
			char ch = board[r][c];
			int idx = ch - 'a';
			int len = builder.length();
			builder.append(ch);
			dfs(board, children[idx], visited, r, c, builder, result);
			builder.setLength(len);
			visited[r][c] = false;
		}

		private void dfs(char[][] board, TrieNode curr, boolean[][] visited, int r, int c, StringBuilder builder, List<String> result) {
			if (curr == null) {
				return;
			} else if (curr.isWord && !curr.isVisited) {
				curr.isVisited = true;
				result.add(builder.toString());
			}
			int rows = board.length;
			int cols = board[0].length;
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i];
				int tc = c + dc[i];
				if (tr >= 0 && tr < rows && tc >= 0 & tc < cols && !visited[tr][tc]) {
					dfs(board, curr.children, visited, tr, tc, builder, result);
				}
			}
		}

		private void insert(TrieNode root, String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				int idx = ch - 'a';
				if (current.children[idx] == null) {
					current.children[idx] = new TrieNode();
				}
				current = current.children[idx];
			}
			current.isWord = true;
		}


		private class TrieNode {
			boolean isWord;
			boolean isVisited;
			TrieNode[] children = new TrieNode[26];
		}
	}

}
