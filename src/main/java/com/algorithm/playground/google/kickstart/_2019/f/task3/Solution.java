package com.algorithm.playground.google.kickstart._2019.f.task3;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edc/000000000018666b
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int[] villages = new int[n];
				for (int i = 0; i < n; i++) {
					villages[i] = console.nextInt();
				}
				@SuppressWarnings("unchecked")
				Set<Integer>[] roads = new HashSet[n];
				for (int i = 0; i < n; i++) {
					roads[i] = new HashSet<>();
				}
				for (int i = 1; i < n; i++) {
					int a = console.nextInt();
					int b = console.nextInt();

					roads[a - 1].add(b - 1);
					roads[b - 1].add(a - 1);
				}
				int ans = solve(villages, roads);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(int[] villages, Set<Integer>[] roads) {
		return solve(villages, roads, new BitSet(), 0);
	}

	private static int solve(int[] villages, Set<Integer>[] roads, BitSet illuminated, int curr) {
		if (curr == villages.length) {
			int ans = 0;
			for (int i = 0; i < villages.length; i++) {
				if (illuminated.get(i)) {
					ans += villages[i];
				}
			}
			return ans;
		} else {
			int a = solve(villages, roads, illuminated, curr + 1);
			BitSet copy = BitSet.valueOf(illuminated.toLongArray());
			copy.set(curr);
			for (Integer next : roads[curr]) {
				copy.set(next);
			}
			int b = solve(villages, roads, copy, curr + 1);
			return Math.max(a, b);
		}
	}

}
