package com.leetcode.problems.unionfind.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/bricks-falling-when-hit/description/
 */
public class BricksFallingWhenHit {

	class Solution {

		private final int[] dr = new int[]{-1, 1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};
		private Map<Integer, Node> cache = new HashMap<>();

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int[] ans = new int[hits.length];
			if (grid.length == 0) {
				return ans;
			}
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < ans.length; i++) {
				int[] hit = hits[i];
				grid[hit[0]][hit[1]] = 0;
				int[] parents = new int[rows * cols];
				Arrays.fill(parents, -1);
				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						if (grid[r][c] == 1) {
							int curr = key(r, c, cols);
							int p1 = find(parents, curr);
							for (int j = 0; j < 4; j++) {
								int tr = r + dr[j], tc = c + dc[j];
								if (tr >= 0 && tr < rows && tc >= 0 && tc < cols && grid[tr][tc] == 1) {
									int neighbour = key(tr, tc, cols);
									int p2 = find(parents, neighbour);
									if (p1 != p2) {
										if (p1 < p2) {
											parents[p2] = p1;
										} else {
											parents[p1] = p2;
										}
									}
									break;
								}
							}
						}
					}
				}
				int count = 0;
				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						if (grid[r][c] == 1) {
							int key = key(r, c, cols);
							int p = find(parents, key);
							if (p > cols) {
								parents[key] = key;
								count++;
								grid[r][c] = 0;
							}
						}
					}
				}
				ans[i] = count;
			}
			return ans;
		}

		private int[] point(int key, int cols) {
			return new int[]{key / cols, key % cols};
		}

		private int key(int r, int c, int cols) {
			return r * cols + c;
		}

		private int find(int[] parents, int key) {
			if (parents[key] == -1) {
				parents[key] = key;
				return key;
			} else if (parents[key] == key) {
				return key;
			}
			int p = find(parents, parents[key]);
			parents[key] = p;
			return p;
		}

		private void union(int key1, int key2) {
			Node n1 = create(key1);
			Node n2 = create(key2);
			if (find(key1).key < find(key2).key) {
				n2.parent = n1;
			} else {
				n1.parent = n2;
			}
		}

		private Node find(int key) {
			Node node = create(key);
			while (node.parent != null) {
				node = node.parent;
			}
			return node;
		}

		private Node create(int key) {
			if (!cache.containsKey(key)) {
				Node node = new Node(key);
				cache.put(key, node);
			}
			return cache.get(key);
		}

		private class Node {
			Node parent;
			List<Node> children = new ArrayList<>();
			int key;

			public Node(int key) {
				this.key = key;
			}

			public Node(Node parent, int key) {
				this(key);
				this.parent = parent;
			}
		}

	}

	class Solution_ {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int[] ans = new int[hits.length];
			if (grid.length == 0) {
				return ans;
			}
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < ans.length; i++) {
				int[] hit = hits[i];
				grid[hit[0]][hit[1]] = 0;
				boolean[][] visited = new boolean[rows][cols];
				for (int c = 0; c < cols; c++) {
					dfs(grid, visited, 0, c);
				}
				int count = 0;
				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						if (grid[r][c] == 1 && !visited[r][c]) {
							grid[r][c] = 0;
							count++;
						}
					}
				}
				ans[i] = count;
			}
			return ans;
		}

		private void dfs(int[][] grid, boolean[][] visited, int r, int c) {
			if (visited[r][c] || grid[r][c] == 0) {
				return;
			}
			visited[r][c] = true;
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i], tc = c + dc[i];
				if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
					dfs(grid, visited, tr, tc);
				}
			}
		}
	}

}
