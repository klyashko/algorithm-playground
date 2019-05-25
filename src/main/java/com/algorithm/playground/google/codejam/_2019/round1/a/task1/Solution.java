package com.algorithm.playground.google.codejam._2019.round1.a.task1;

import java.util.*;

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
						System.out.println(p[0] + " " + p[1]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static LinkedList<int[]> solve(int rows, int cols) {
		boolean[] used = new boolean[rows * cols];
		List<Integer> moves = new ArrayList<>();
		for (int i = 0; i < used.length; i++) {
			moves.add(i);
		}

		Collections.shuffle(moves);
		Collections.shuffle(moves);

		LinkedList<int[]> path = new LinkedList<>();
		for (Integer i : moves) {
			used[i] = true;
			int r = i / cols;
			int c = i % cols;
			path.addLast(new int[]{r + 1, c + 1});
			if (dp(used, moves, r, c, cols, path)) {
				break;
			}
			path.removeLast();
			used[i] = false;
		}
		return path;
	}

	private static boolean dp(boolean[] used, List<Integer> moves, int r, int c, int cols, LinkedList<int[]> path) {
		boolean done = true;
		for (int next : moves) {
			if (!used[next]) {
				done = false;
				int tr = next / cols;
				int tc = next % cols;
				if (tr != r && tc != c && (r + c) != (tr + tc) && (r - c) != (tr - tc)) {
					used[next] = true;
					path.addLast(new int[]{tr + 1, tc + 1});
					if (dp(used, moves, tr, tc, cols, path)) {
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
