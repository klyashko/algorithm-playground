package com.algorithm.playground.google.kickstart._2019.f.task3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.max;

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
				@SuppressWarnings("unchecked")
				Set<Integer>[] roads = new HashSet[n];
				for (int i = 0; i < n; i++) {
					villages[i] = console.nextInt();
					roads[i] = new HashSet<>();
				}

				for (int i = 1; i < n; i++) {
					int a = console.nextInt();
					int b = console.nextInt();

					roads[a - 1].add(b - 1);
					roads[b - 1].add(a - 1);
				}
				long ans = solve(villages, roads);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static long solve(int[] villages, Set<Integer>[] roads) {
		long[] dynUp = new long[villages.length];
		long[] dynNothing = new long[villages.length];
		long[] dynDown = new long[villages.length];
		dp(villages, roads, 0, -1, dynUp, dynNothing, dynDown);
		return Math.max(dynUp[0], dynNothing[0]);
	}

	private static void dp(int[] villages, Set<Integer>[] roads, int curr, int parent, long[] dynUp, long[] dynNothing, long[] dynDown) {
		long dDark = 0;
		long dLightHere = villages[curr];
		long dLightBelow = Long.MIN_VALUE;
		for (int next : roads[curr]) {
			if (next != parent) {
				dp(villages, roads, next, curr, dynUp, dynNothing, dynDown);
				if (dLightBelow == Long.MIN_VALUE) {
					dLightBelow = dynUp[next] + villages[curr];
				} else {
					dLightBelow = max(dLightBelow + max(dynNothing[next], dynUp[next]), dDark + dynUp[next] + villages[curr]);
				}
				dDark += dynNothing[next];
				dLightHere += dynDown[next];
			}
		}
		dynNothing[curr] = max(dDark, dLightBelow);
		dynUp[curr] = dLightHere;
		dynDown[curr] = max(dLightHere, max(dLightBelow, dDark + villages[curr]));
	}

}
