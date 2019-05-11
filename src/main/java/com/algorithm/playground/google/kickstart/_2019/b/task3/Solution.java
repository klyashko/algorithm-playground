package com.algorithm.playground.google.kickstart._2019.b.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int[] row = new int[console.nextInt()];
				int s = console.nextInt();
				for (int i = 0; i < row.length; i++) {
					row[i] = console.nextInt();
				}
				int ans = solve(row, s);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(int[] row, int s) {
		State[] col = new State[row.length];
		int max = 0;
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (col[j] == null) {
					col[j] = new State(s);
				}
				col[j].add(row[i]);
				max = Math.max(max, col[j].score);
			}
		}

		return max;
	}

	private static class State {

		private int score, limit;
		private Map<Integer, Integer> counts = new HashMap<>();

		private State(int limit) {
			this.limit = limit;
		}

		private void add(int type) {
			Integer prev = counts.getOrDefault(type, 0);
			if (prev == limit) {
				score -= prev;
			} else if (prev < limit) {
				score++;
			}
			counts.put(type, prev + 1);
		}

		@Override
		public String toString() {
			return "State{" +
					"score=" + score +
					", limit=" + limit +
					", counts=" + counts +
					'}';
		}
	}

}
