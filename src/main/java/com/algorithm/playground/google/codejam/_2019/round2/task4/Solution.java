package com.algorithm.playground.google.codejam._2019.round2.task4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051679/0000000000146185
 */
public class Solution {

	private static final long MOD = 1_000_000_007;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				IntList[] edges = IntList.arrayOf(n);
				IntList[] reversed = IntList.arrayOf(n);
				for (int i = 0; i < n; i++) {
					int a = console.nextInt() - 1;
					int b = console.nextInt() - 1;

					edges[i].add(a);
					edges[i].add(b);

					reversed[a].add(i);
					reversed[b].add(i);
				}

				long[] store = new long[n];
				for (int i = 0; i < n; i++) {
					store[i] = console.nextInt();
				}

				long ans = solve(edges, reversed, store);
				System.out.println(String.format("Case #%s: %s", test, ans == -1 ? "UNBOUNDED" : ans));
			}
		}
	}

	private static long solve(IntList[] edges, IntList[] reversed, long[] store) {
		int n = store.length;
		int[] components = new int[n];
		int comp = scc(edges, reversed, components);
		boolean[] hasLoop = new boolean[comp];
		IntList[] cond = IntList.arrayOf(comp);

		for (int i = 0; i < n; i++) {
			IntList l = edges[i];
			for (int j = 0; j < l.size(); j++) {
				int ci = components[i], cj = components[l.get(j)];
				if (ci != cj) {
					cond[ci].add(cj);
				} else {
					hasLoop[ci] = true;
				}
			}
		}

		if (isUnbound(edges, cond, store, components, hasLoop)) {
			return -1;
		}
		return sum(cond, store, components);
	}

	private static long sum(IntList[] cond, long[] store, int[] components) {
		int[] ways = count(cond, components[0]);
		long sum = 0;
		for (int i = 0; i < store.length; i++) {
			sum += store[i] * ways[components[i]];
			sum %= MOD;
		}

		return sum;
	}

	private static boolean isUnbound(IntList[] edges, IntList[] cond, long[] store, int[] components, boolean[] hasLoop) {
		boolean[] reachableFromOne = reachableFromOne(components, store, cond);
		boolean[] canReach0 = canReach0(cond, components[0]);
		boolean[] count = new boolean[reachableFromOne.length];
		int[] size = new int[reachableFromOne.length];

		for (int i = 0; i < edges.length; i++) {
			IntList l = edges[i];
			int realDegree = 0;
			for (int j = 0; j < l.size(); j++) {
				if (canReach0[components[l.get(j)]]) {
					realDegree++;
				}
			}

			count[components[i]] |= realDegree == 2;
			size[components[i]]++;
		}

		for (int i = 0; i < reachableFromOne.length; i++) {
			if (reachableFromOne[i] && canReach0[i] && count[i]) {
				if (hasLoop[i] || size[i] >= 2) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean[] canReach0(IntList[] cond, int comp) {
		boolean[] canReach0 = new boolean[cond.length];
		canReach0[comp] = true;

		for (int i = cond.length - 1; i >= 0; i--) {
			IntList l = cond[i];
			for (int j = 0; j < l.size(); j++) {
				canReach0[i] |= canReach0[l.get(j)];
			}
		}
		return canReach0;
	}

	private static int scc(IntList[] edges, IntList[] reversed, int[] components) {
		int[] order = new int[edges.length];
		boolean[] visited = new boolean[edges.length];
		int[] idx = {0};
		for (int i = 0; i < edges.length; i++) {
			order(edges, i, idx, order, visited);
		}

		Arrays.fill(visited, false);
		int comp = 0;

		for (int i = edges.length - 1; i >= 0; i--) {
			mark(reversed, order[i], components, visited, comp++);
		}
		return comp;
	}

	private static int[] count(IntList[] cond, int comp) {
		int[] ways = new int[cond.length];
		ways[comp] = 1;
		for (int i = cond.length - 1; i >= 0; i--) {
			IntList l = cond[i];
			for (int j = 0; j < l.size(); j++) {
				ways[i] += ways[l.get(j)];
				ways[i] %= MOD;
			}
		}
		return ways;
	}

	private static boolean[] reachableFromOne(int[] components, long[] store, IntList[] cond) {
		boolean[] reachableFromOne = new boolean[cond.length];
		for (int i = 0; i < components.length; i++) {
			reachableFromOne[components[i]] |= store[i] > 0;
		}

		for (int i = 0; i < cond.length; i++) {
			IntList l = cond[i];
			for (int j = 0; j < l.size(); j++) {
				reachableFromOne[l.get(j)] |= reachableFromOne[i];
			}
		}
		return reachableFromOne;
	}

	private static void mark(IntList[] graph, int node, int[] components, boolean[] visited, int component) {
		if (!visited[node]) {
			visited[node] = true;
			components[node] = component;
			for (int i = 0; i < graph[node].size(); i++) {
				mark(graph, graph[node].get(i), components, visited, component);
			}
		}
	}

	private static void order(IntList[] graph, int node, int[] idx, int[] order, boolean[] visited) {
		if (!visited[node]) {
			visited[node] = true;
			for (int i = 0; i < graph[node].size(); i++) {
				order(graph, graph[node].get(i), idx, order, visited);
			}
			order[idx[0]++] = node;
		}
	}

	private static class IntList {

		private int[] values;
		private int size;

		private IntList() {
			this.values = new int[10];
		}

		private static IntList[] arrayOf(int rows) {
			IntList[] list = new IntList[rows];
			for (int i = 0; i < rows; i++) {
				list[i] = new IntList();
			}
			return list;
		}

		private void add(int val) {
			ensureCapacity(size);
			values[size++] = val;
		}

		private int get(int idx) {
			return values[idx];
		}

		private int size() {
			return size;
		}

		private void ensureCapacity(int idx) {
			if (values.length <= idx) {
				int[] newValues = new int[values.length << 1];
				System.arraycopy(values, 0, newValues, 0, values.length);
				values = newValues;
			}
		}

	}

}
