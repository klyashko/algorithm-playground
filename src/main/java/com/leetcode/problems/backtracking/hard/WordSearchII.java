package com.leetcode.problems.backtracking.hard;

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
					visited[r][c] = true;
					char ch = board[r][c];
					int idx = ch - 'a';
					builder.append(ch);
					dfs(board, root.children[idx], visited, r, c, builder, result);
					builder.setLength(0);
					visited[r][c] = false;
				}
			}
			return result;
		}

		private void dfs(char[][] board, TrieNode curr, boolean[][] visited, int r, int c, StringBuilder builder, List<String> result) {
			if (curr == null) {
				return;
			} else if (curr.isWord) {
				result.add(builder.toString());
			}
			int rows = board.length;
			int cols = board[0].length;
			int len = builder.length();
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i];
				int tc = c + dc[i];
				if (tr >= 0 && tr < rows && tc >= 0 & tc < cols && !visited[tr][tc]) {
					visited[tr][tc] = true;
					char ch = board[tr][tc];
					int idx = ch - 'a';
					builder.append(ch);
					dfs(board, curr.children[idx], visited, tr, tc, builder, result);
					visited[tr][tc] = false;
					builder.setLength(len);
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
			TrieNode[] children = new TrieNode[26];
		}
	}

}
