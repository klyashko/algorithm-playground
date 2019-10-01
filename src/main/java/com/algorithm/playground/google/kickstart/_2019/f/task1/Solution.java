package com.algorithm.playground.google.kickstart._2019.f.task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edc/000000000018666c
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int k = console.nextInt();
				int[] wall = new int[n];
				for (int i = 0; i < n; i++) {
					wall[i] = console.nextInt();
				}
				int ans = solve(wall, k);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(int[] wall, int k) {
		if (k >= wall.length) {
			return 0;
		}
		int n = wall.length;
		int[][] dp = new int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, n);
		}
		for (int i = 0; i < n; i++) {
			int[] counts = new int[1001];
			int max = 0;
			for (int j = i; j >= 0; j--) {
				counts[wall[j]]++;
				max = Math.max(max, counts[wall[j]]);
				int cost = i - j - max + 1;
				if (j == 0) {
					dp[i][0] = cost;
				} else {
					for (int l = 0; l < i; l++) {
						dp[i][l + 1] = Math.min(dp[i][l + 1], dp[j - 1][l] + cost);
					}
				}
			}
		}
//		print(dp);
		return dp[n - 1][k];
	}

	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("--------------------------------");
	}

}