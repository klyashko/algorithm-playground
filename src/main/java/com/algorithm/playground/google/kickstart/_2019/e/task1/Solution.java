package com.algorithm.playground.google.kickstart._2019.e.task1;

import java.util.*;

import static java.util.Collections.emptySet;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edb/0000000000170721
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int m = console.nextInt();
				Map<Integer, Set<Integer>> edges = new HashMap<>();
				for (int i = 0; i < m; i++) {
					int v1 = console.nextInt();
					int v2 = console.nextInt();
					edges.computeIfAbsent(v1, key -> new HashSet<>()).add(v2);
					edges.computeIfAbsent(v2, key -> new HashSet<>()).add(v1);
				}
				int ans = solve(n, edges);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(int n, Map<Integer, Set<Integer>> edges) {
		int comp = 0;
		BitSet visited = new BitSet();
		for (int i = 1; i <= n; i++) {
			if (!visited.get(i)) {
				dfs(i, edges, visited);
				comp++;
			}
		}
		int red = comp - 1;
		int black = n - red - 1;
		return black + (red << 1);
	}

	private static void dfs(Integer curr, Map<Integer, Set<Integer>> edges, BitSet visited) {
		if (!visited.get(curr)) {
			visited.set(curr);
			for (Integer next : edges.getOrDefault(curr, emptySet())) {
				dfs(next, edges, visited);
			}
		}
	}

}
