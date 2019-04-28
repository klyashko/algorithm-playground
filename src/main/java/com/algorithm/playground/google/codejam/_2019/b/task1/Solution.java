package com.algorithm.playground.google.codejam._2019.b.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

@SuppressWarnings("Duplicates")
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//rows
				int p = console.nextInt();
				//grid
				int q = console.nextInt();
				Point[] points = new Point[p];
				for (int i = 0; i < points.length; i++) {
					points[i] = new Point(console.nextInt(), console.nextInt(), console.next());
				}
				int[] ans = solve(points, q);
				System.out.println(String.format("Case #%s: %s %s", test, ans[0], ans[1]));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int[] solve(Point[] points, int max) {
		TreeSet<Integer> xCoor = new TreeSet<>();
		TreeSet<Integer> yCoor = new TreeSet<>();

		xCoor.add(0);
		xCoor.add(max);

		yCoor.add(0);
		yCoor.add(max);

		for (Point p : points) {
			int x = x(p.x, p.d);
			int y = y(p.y, p.d);

			xCoor.add(x);
			yCoor.add(y);
		}
		int[][] grid = new int[yCoor.size()][xCoor.size()];
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		Map<Integer, Integer> xrMap = new HashMap<>();
		Map<Integer, Integer> yrMap = new HashMap<>();

		int tmp = 0;
		for (Integer i : xCoor) {
			xMap.put(i, tmp);
			xrMap.put(tmp, i);
			tmp++;
		}
		tmp = 0;
		for (Integer i : yCoor) {
			yMap.put(i, tmp);
			yrMap.put(tmp, i);
			tmp++;
		}

		for (Point p : points) {
			switch (p.d) {
				case "N":
					for (int x = 0; x < grid[0].length; x++) {
						for (int y = yMap.get(p.y + 1); y < grid.length; y++) {
							grid[y][x]++;
						}
					}
					break;
				case "S":
					for (int x = 0; x < grid[0].length; x++) {
						for (int y = yMap.get(p.y - 1); y >= 0; y--) {
							grid[y][x]++;
						}
					}
					break;
				case "E":
					for (int x = xMap.get(p.x + 1); x < grid[0].length; x++) {
						for (int y = 0; y < grid.length; y++) {
							grid[y][x]++;
						}
					}
					break;
				case "W":
					for (int x = xMap.get(p.x - 1); x >= 0; x--) {
						for (int y = 0; y < grid.length; y++) {
							grid[y][x]++;
						}
					}
					break;
			}
		}

		int m = 0;

		int xM = 0, yM = 0;

		for (int y = grid.length - 1; y >= 0; y--) {
			for (int x = grid[0].length - 1; x >= 0; x--) {
				if (grid[y][x] >= m) {
					xM = x;
					yM = y;
					m = grid[y][x];
				}
			}
		}

		int x = Math.max(0, xrMap.get(xM));
		int y = Math.max(0, yrMap.get(yM));

		return new int[]{Math.min(x, max), Math.min(y, max)};
	}

	private static int x(int x, String d) {
		switch (d) {
			case "E":
				return x + 1;
			case "W":
				return x - 1;
			default:
				return x;
		}
	}

	private static int y(int y, String d) {
		switch (d) {
			case "N":
				return y + 1;
			case "S":
				return y - 1;
			default:
				return y;
		}
	}

	private static class Point {
		private int x, y;
		private String d;

		public Point(int x, int y, String d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	private static class Scanner implements AutoCloseable {

		private final BufferedReader br;
		private StringTokenizer st;

		Scanner(InputStream is) {
			this.br = new BufferedReader(new InputStreamReader(is));
		}

		@Override
		public void close() {
			try {
				br.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public String next() {
			read();
			return st == null ? null : st.nextToken();
		}

		public boolean hasNext() {
			read();
			return st != null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		private void read() {
			if (st == null || !st.hasMoreTokens()) {
				try {
					String line = br.readLine();
					if (line == null) {
						st = null;
					} else {
						st = new StringTokenizer(line);
					}
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
