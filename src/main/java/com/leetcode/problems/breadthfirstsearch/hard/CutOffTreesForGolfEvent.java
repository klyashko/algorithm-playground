package com.leetcode.problems.breadthfirstsearch.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
 */
public class CutOffTreesForGolfEvent {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int cutOffTree(List<List<Integer>> forest) {
			Queue<Point> queueToCut = new PriorityQueue<>(Comparator.comparingInt(n -> forest.get(n.r).get(n.c)));
			for (int r = 0; r < forest.size(); r++) {
				List<Integer> l = forest.get(r);
				for (int c = 0; c < l.size(); c++) {
					Integer val = forest.get(r).get(c);
					if (val > 1) {
						queueToCut.add(new Point(r, c));
					}
				}
			}
			int steps = 0;
			Point curr = new Point(0, 0);

			while (!queueToCut.isEmpty()) {
				Point next = queueToCut.poll();
				int dist = distance(curr, next, forest);
				if (dist == -1) {
					return -1;
				}
				steps += dist;
				//noinspection ConstantConditions
				forest.get(next.r).set(next.c, 1);
				curr = next;
			}

			return steps;
		}

		private int distance(Point from, Point to, List<List<Integer>> forest) {
			Set<Point> visited = new HashSet<>();
			Queue<Point> queue = new ArrayDeque<>();
			queue.add(from);
			visited.add(from);
			int steps = -1;

			while (!queue.isEmpty()) {
				int size = queue.size();
				steps++;
				while (size > 0) {
					Point curr = queue.poll();
					size--;
					//noinspection ConstantConditions
					if (curr.equals(to)) {
						return steps;
					}
					if (forest.get(curr.r).get(curr.c) == 0) {
						continue;
					}
					for (int i = 0; i < 4; i++) {
						int r = curr.r + dr[i];
						int c = curr.c + dc[i];
						if (r >= 0 && r < forest.size() && c >= 0 && c < forest.get(r).size()) {
							Point next = new Point(r, c);
							if (visited.add(next)) {
								queue.add(next);
							}
						}
					}
				}
			}

			return -1;
		}

		private class Point {
			int r, c;

			private Point(int r, int c) {
				this.r = r;
				this.c = c;
			}

			@Override
			public String toString() {
				return "Node{" +
						"r=" + r +
						", c=" + c +
						'}';
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Point node = (Point) o;
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
