package com.algorithm.playground.google.kickstart._2019.a.task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e01/00000000000698d6
 */
public class Solution {

	public static void main(String[] args) {
		try {
			Scanner console = new Scanner(System.in);
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int[] players = new int[console.nextInt()];
				int n = console.nextInt();
				for (int idx = 0; idx < players.length; idx++) {
					players[idx] = console.nextInt();
				}

				System.out.println(String.format("Case #%s: %s", test, solve(players, n)));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	static int solve(int[] players, int n) {
		Arrays.sort(players);
		int sum = 0;
		for (int idx = 0; idx < n; idx++) {
			sum += players[idx];
		}
		int min = players[n - 1] * n - sum;
		for (int i = n; i < players.length; i++) {
			sum -= players[i - n];
			sum += players[i];
			min = Math.min(min, players[i] * n - sum);
		}
		return min;
	}

}
