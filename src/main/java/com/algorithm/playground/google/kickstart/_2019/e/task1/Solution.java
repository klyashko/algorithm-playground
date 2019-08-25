package com.algorithm.playground.google.kickstart._2019.e.task1;

import java.util.*;

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
		int visitedEdges = 0;
		Set<Integer> visited = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			if (edges.containsKey(i)) {
				int size = visited.size();
				dfs(i, edges, visited);
				visitedEdges += Math.max(0, visited.size() - size - 1);
			}
		}
		int expected = n - 1;
//		System.out.println("VE=" + visitedEdges + " e=" + expected);
//		int visitedCount = Math.max(0, visited.size() - 1);
		if (visitedEdges > expected) {
			return expected;
		} else {
			return visitedEdges + (expected - visitedEdges << 1);
		}
	}

	private static void dfs(Integer curr, Map<Integer, Set<Integer>> edges, Set<Integer> visited) {
		if (visited.add(curr)) {
			LinkedList<Integer> stack = new LinkedList<>();
			stack.push(curr);

			while (!stack.isEmpty()) {
				curr = stack.pop();
				for (Integer next : edges.getOrDefault(curr, Collections.emptySet())) {
					if (visited.add(next)) {
						stack.push(next);
					}
				}
			}
		}
	}

}
