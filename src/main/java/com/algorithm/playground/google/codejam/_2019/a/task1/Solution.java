package com.algorithm.playground.google.codejam._2019.a.task1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635/0000000000104e03
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int r = console.nextInt();
				int c = console.nextInt();
				LinkedList<int[]> ans = solve(r, c);
				if (ans.isEmpty()) {
					System.out.println(String.format("Case #%s: IMPOSSIBLE", test));
				} else {
					System.out.println(String.format("Case #%s: POSSIBLE", test));
					for (int[] p : ans) {
						System.out.println((p[1] + 1) + " " + (p[0] + 1));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static LinkedList<int[]> solve(int rows, int cols) {
		boolean[] used = new boolean[rows * cols];
		LinkedList<int[]> path = new LinkedList<>();
		for (int i = 0; i < used.length; i++) {
			used[i] = true;
			int r = i / rows;
			int c = i % rows;
			path.addLast(new int[]{r, c});
			if (dp(used, i, rows, cols, path)) {
				break;
			}
			path.removeLast();
			used[i] = false;
		}
		return path;
	}

	private static boolean dp(boolean[] used, int curr, int rows, int cols, LinkedList<int[]> path) {
		int r = curr / rows;
		int c = curr % rows;
		boolean done = true;
		for (int next = 0; next < used.length; next++) {
			if (!used[next]) {
				done = false;
				int tr = next / rows;
				int tc = next % rows;
				if (tr != r && tc != c && (r + c) != (tr + tc) && (r - c) != (tr - tc)) {
					used[next] = true;
					path.addLast(new int[]{tr, tc});
					if (dp(used, next, rows, cols, path)) {
						return true;
					}
					path.removeLast();
					used[next] = false;
				}
			}
		}
		return done;
	}

}
