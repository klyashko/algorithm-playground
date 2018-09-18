package com.leetcode.problems.breadthfirstsearch.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
 */
public class ShortestPathToGetAllKeys {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int shortestPathAllKeys(String[] grid) {
			Node start = null;
			int keys = 0;
			int rows = grid.length;
			int cols = grid[0].length();

			for (int i = 0; i < rows; i++) {
				String s = grid[i];
				for (int j = 0; j < cols; j++) {
					char ch = s.charAt(j);
					if (ch == '@') {
						start = new Node(i, j);
					}
					if (Character.isLowerCase(ch)) {
						keys++;
					}
				}
			}

			int steps = -1;
			Queue<Node> queue = new ArrayDeque<>();
			Map<String, Set<Node>> seen = new HashMap<>();
			queue.add(start);
			seen.put("", new HashSet<>());
			seen.get("").add(start);

			while (!queue.isEmpty()) {
				int size = queue.size();
				steps++;
				while (size > 0) {
					Node curr = queue.poll();
					size--;
					//noinspection ConstantConditions
					char ch = grid[curr.r].charAt(curr.c);
					if (ch == '#') {
						continue;
					} else if (Character.isUpperCase(ch)) {
						if (1 << (ch - 'A') != (curr.keys & 1 << (ch - 'A'))) {
							continue;
						}
					} else if (Character.isLowerCase(ch)) {
						curr.keys = curr.keys | 1 << (ch - 'a');
						if (curr.keys == (1 << keys) - 1) {
							System.out.println(curr);
							return steps;
						}
					}
					for (int i = 0; i < 4; i++) {
						int tr = curr.r + dr[i];
						int tc = curr.c + dc[i];
						if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
							Node next = new Node(tr, tc);
							String key = Integer.toString(curr.keys);
							if (!seen.containsKey(key)) {
								seen.put(key, new HashSet<>());
							}
							if (seen.get(key).add(next)) {
								next.keys = curr.keys;
//								next.prev = curr;
								queue.offer(next);
							}
						}
					}

				}
//				System.out.println(queue);

			}

			return -1;
		}

		private class Node {
			int r, c, keys;
			Node prev;

			public Node(int r, int c) {
				this.r = r;
				this.c = c;
			}

			@Override
			public String toString() {
				return "Node{" +
						"r=" + r +
						", c=" + c +
						", keys=" + keys +
						", prev=\n" + prev +
						'}';
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Node node = (Node) o;
				return r == node.r &&
						c == node.c;
			}

			@Override
			public int hashCode() {
				return Objects.hash(r, c);
			}
		}
	}

}
