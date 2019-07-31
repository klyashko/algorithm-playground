package com.algorithm.playground.google.kickstart._2019.d.task1;

import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.Integer.bitCount;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000051061/0000000000161426
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int q = console.nextInt();
				TreeSet<Integer> odds = new TreeSet<>();
				for (int i = 0; i < n; i++) {
					if (!isEven(bitCount(console.nextInt()))) {
						odds.add(i);
					}
				}

				System.out.print("Case #" + test + ": ");
				for (int i = 0; i < q; i++) {
					int idx = console.nextInt();

					odds.remove(idx);

					if (!isEven(bitCount(console.nextInt()))) {
						odds.add(idx);
					}

					int ans;
					if (isEven(odds.size())) {
						ans = n;
					} else {
						ans = Math.max(n - odds.first() - 1, odds.last());
					}
					System.out.print(ans + " ");
				}
				System.out.println();
			}
		}
	}

	private static boolean isEven(int i) {
		return (i & 1) == 0;
	}

}
