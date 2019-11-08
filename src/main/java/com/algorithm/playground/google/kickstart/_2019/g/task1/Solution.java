package com.algorithm.playground.google.kickstart._2019.g.task1;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050e02/000000000018fd0d
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int m = console.nextInt();
				int q = console.nextInt();

				BitSet pages = new BitSet(n + 1);
				for (int i = 0; i < m; i++) {
					pages.set(console.nextInt());
				}

				Map<Integer, Integer> numbers = new HashMap<>();
				for (int i = 0; i < q; i++) {
					numbers.merge(console.nextInt(), 1, Integer::sum);
				}

				long ans = solve(n, pages, numbers);
				System.out.println("Case #" + test + ": " + ans);
			}
		}

	}

	private static long solve(int n, BitSet pages, Map<Integer, Integer> numbers) {
		long sum = 0;
		for (Entry<Integer, Integer> e : numbers.entrySet()) {
			for (int p = e.getKey(); p <= n; p += e.getKey()) {
				if (!pages.get(p)) {
					sum += e.getValue();
				}
			}
		}
		return sum;
	}

}
