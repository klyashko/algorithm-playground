package com.algorithm.playground.leetcode.problems.lc800.lc840.lc847;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/
 */
public class ShortestPathVisitingAllNodes {

	class Solution {
		public int shortestPathLength(int[][] graph) {
			int N = graph.length;

			Queue<Node> queue = new LinkedList<>();
			int[][] dist = new int[1 << N][N];

			for (int[] row : dist) {
				Arrays.fill(row, N * N);
			}

			for (int x = 0; x < N; x++) {
				queue.add(new Node(1 << x, x));
				dist[1 << x][x] = 0;
			}

			while (!queue.isEmpty()) {
				Node current = queue.poll();
				int d = dist[current.cover][current.head];
				if (current.cover == (1 << N) - 1) {
					return d;
				}

				for (int child : graph[current.head]) {
					int cover2 = current.cover | (1 << child);
					if (d + 1 < dist[cover2][child]) {
						dist[cover2][child] = d + 1;
						queue.add(new Node(cover2, child));
					}
				}
			}

			return 0;
		}

		private class Node {
			int cover, head;

			private Node(int cover, int head) {
				this.cover = cover;
				this.head = head;
			}
		}
	}

}
