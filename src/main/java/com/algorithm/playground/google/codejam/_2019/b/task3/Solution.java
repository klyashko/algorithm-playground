package com.algorithm.playground.google.codejam._2019.b.task3;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
//		4 0
//		1 1 1 8
//		8 8 8 8
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int k = console.nextInt();
				int[] c = new int[n];
				for (int i = 0; i < c.length; i++) {
					c[i] = console.nextInt();
				}
				int[] d = new int[n];
				for (int i = 0; i < d.length; i++) {
					d[i] = console.nextInt();
				}
				int ans = solve(c, d, k);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(int[] c, int[] d, int k) {
//		int[][] diffs = new int[c.length][c.length];
		boolean[][] taken = new boolean[c.length][c.length];
		int count = 0;
		for (int y = 0; y < c.length; y++) {
			for (int x = y; x < c.length; x++) {
//				int ci;
//				int di;
//				if (c[y] > c[x]) {
//					ci = c[y];
//					di = d[x];
//				} else if (c[y] == c[x]) {
//					ci = d[y] > d[x] ? c[x] : c[y];
//					di = d[y] > d[x] ? d[y] : d[y];
//				}

//				int ci = c[y] > c[x]
				int ci = Math.max(c[y], c[x]);
				int di = Math.max(d[y], d[x]);
				if (Math.abs(ci - di) <= k) {
//					if (!taken[y][x] && !taken[x][y])
					count++;
//					taken[x][y] = true;
//					taken[y][x] = true;
				}
//				if(Math.abs(c[y] - d[x]) <= k || Math.abs(c[x] - d[y]) <= k){
//					count++;
//				}
//				if(Math.abs(c[x] - d[y]) <= k){
//					count++;
//				}
//				int val = Math.max(
//						Math.abs(c[y] - d[x]),
//						Math.abs(c[x] - d[y])
//				);
////				if (diffs[y][x] <= k) {
//				if (val <= k) {
//					count++;
//				}
			}
		}
		return count;
	}

}
