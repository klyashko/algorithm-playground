package com.algorithm.playground.google.kickstart._2019.c.task1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static final int[] DR = {0, 0, 1, -1};
	private static final int[] DC = {-1, 1, 0, 0};

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//skip N
				console.nextInt();
				int R = console.nextInt();
				// skip number of columns
				console.nextInt();
				int SR = console.nextInt();
				int SC = console.nextInt();
				String moves = console.next();
				int[] ans = solve(R, SR, SC, moves);
				System.out.println(String.format("Case #%s: %s %s", test, ans[0], ans[1]));
			}
		}
	}

	private static int[] solve(int rows, int r, int c, String moves) {
		@SuppressWarnings("unchecked")
		Set<Integer>[] rowSet = new Set[rows + 1];
		for (int i = 0; i < rowSet.length; i++) {
			rowSet[i] = new HashSet<>();
		}
		rowSet[r].add(c);

		for (char ch : moves.toCharArray()) {
			int idx = direction(ch);
			do {
				r += DR[idx];
				c += DC[idx];
			} while (!rowSet[r].add(c));
		}

		return new int[]{r, c};
	}

	private static int direction(char ch) {
		switch (ch) {
			case 'W':
				return 0;
			case 'E':
				return 1;
			case 'S':
				return 2;
			default:
				return 3;
		}
	}

}
