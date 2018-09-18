package com.leetcode.problems.breadthfirstsearch.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
 */
public class ShortestPathToGetAllKeys {

	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('v');
		set.add('b');
		System.out.println(set);
//		System.out.println(String.join("", set));
	}

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
					if (ch >= 'a' && ch <= 'z') {
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
					} else if (ch >= 'A' && ch <= 'Z') {
						if (!curr.keys.contains((char) (ch + 32))) {
							continue;
						}
					} else if (ch >= 'a' && ch <= 'z') {
						Set<Character> set = new HashSet<>(curr.keys);
						set.add(ch);
						curr.keys = set;
//						curr.keys.add(ch);
						if (curr.keys.size() == keys) {
							System.out.println(curr);
							return steps;
						}
					}
					for (int i = 0; i < 4; i++) {
						int tr = curr.r + dr[i];
						int tc = curr.c + dc[i];
						if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
							Node next = new Node(tr, tc);
							String key = toString(curr.keys);
							if (!seen.containsKey(key)) {
								seen.put(key, new HashSet<>());
							}
							if (seen.get(key).add(next)) {
								next.keys = curr.keys;
//								next.keys.addAll(curr.keys);
								next.prev = curr;
								queue.offer(next);
							}
						}
					}

				}
//				System.out.println(queue);

			}

			return -1;
		}

		private String toString(Set<Character> set) {
			StringBuilder builder = new StringBuilder();
			for (char ch : set) {
				builder.append(ch);
			}
			return builder.toString();
		}

		private class Node {
			int r, c;
			Set<Character> keys = new HashSet<>();
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
