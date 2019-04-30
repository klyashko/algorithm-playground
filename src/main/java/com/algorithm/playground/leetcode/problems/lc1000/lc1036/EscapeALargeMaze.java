package com.algorithm.playground.leetcode.problems.lc1000.lc1036;

import java.util.*;

/**
 * https://leetcode.com/problems/escape-a-large-maze/
 * <p>
 * In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
 * <p>
 * We start at the source square and want to reach the target square.
 * Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
 * <p>
 * Return true if and only if it is possible to reach the target square through a sequence of moves.
 */
public class EscapeALargeMaze {

	class Solution {

		private final int[] dr = {1, -1, 0, 0};
		private final int[] dc = {0, 0, 1, -1};
		private final int LIMIT = 1_000_000;

		public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

			TreeSet<Integer> xCoor = new TreeSet<>();
			TreeSet<Integer> yCoor = new TreeSet<>();

			add(source, xCoor, yCoor);
			add(target, xCoor, yCoor);

			for (int[] b : blocked) {
				add(b, xCoor, yCoor);
			}

			Map<Integer, Integer> xMap = new HashMap<>();
			Map<Integer, Integer> yMap = new HashMap<>();

			int idx = 0;
			int maxX = 0;
			for (Integer i : xCoor) {
				xMap.put(i, idx++);
				maxX = i;
			}

			idx = 0;
			int maxY = 0;
			for (Integer i : yCoor) {
				yMap.put(i, idx++);
				maxY = i;
			}

			Cell start = new Cell(xMap.get(source[0]), yMap.get(source[1]));
			Cell dest = new Cell(xMap.get(target[0]), yMap.get(target[1]));

			Queue<Cell> queue = new PriorityQueue<>(Comparator.comparingDouble(c -> distanceTo(c, dest)));
			Set<Cell> seen = new HashSet<>();

			for (int[] b : blocked) {
				seen.add(new Cell(xMap.get(b[0]), yMap.get(b[1])));
			}

			queue.offer(start);
			seen.add(dest);

			while (!queue.isEmpty()) {
				Cell curr = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = curr.x + dr[i];
					int y = curr.y + dc[i];
					if (valid(x, y, maxX, maxY)) {
						if (dest.equals(x, y)) {
							return true;
						} else {
							Cell next = new Cell(x, y);
							if (seen.add(next)) {
								queue.offer(next);
							}
						}
					}
				}
			}

			return false;
		}

		private void add(int[] point, TreeSet<Integer> xCoor, TreeSet<Integer> yCoor) {
			xCoor.add(point[0]);
			yCoor.add(point[1]);
			for (int i = 0; i < 4; i++) {
				int x = point[0] + dr[i];
				int y = point[1] + dc[i];
				if (valid(x, y, LIMIT, LIMIT)) {
					xCoor.add(x);
					yCoor.add(y);
				}
			}
		}

		private boolean valid(int x, int y, int xLimit, int yLimit) {
			return x >= 0 && x <= xLimit && y >= 0 && y <= yLimit;
		}

		private double distanceTo(Cell cell, Cell target) {
			double a = Math.pow(cell.x - target.x, 2);
			double b = Math.pow(cell.y - target.y, 2);
			return Math.sqrt(a + b);
		}

		private class Cell {
			private final int x, y;

			private Cell(int x, int y) {
				this.x = x;
				this.y = y;
			}

			public boolean equals(int x, int y) {
				return this.x == x && this.y == y;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Cell cell = (Cell) o;
				return x == cell.x &&
						y == cell.y;
			}

			@Override
			public int hashCode() {
				return Objects.hash(x, y);
			}

			@Override
			public String toString() {
				return "Cell{" +
						"x=" + x +
						", y=" + y +
						'}';
			}
		}

	}

}
