package com.algorithm.playground.leetcode.problems.lc900.lc990;

import java.util.*;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class SatisfiabilityOfEqualityEquations {

	class Solution {
		public boolean equationsPossible(String[] equations) {
			DSU dsu = new DSU();
			int idx = 0, len = equations.length;
			for (String eq : equations) {
				if (eq.charAt(1) == '=') {
					int i1 = eq.charAt(0) - 'a';
					int i2 = eq.charAt(3) - 'a';
					dsu.union(i1, i2);
					len--;
				} else {
					equations[idx++] = eq;
				}
			}
			for (String eq : Arrays.copyOf(equations, len)) {
				if (eq.charAt(1) == '!') {
					int i1 = eq.charAt(0) - 'a';
					int i2 = eq.charAt(3) - 'a';
					if (dsu.find(i1) == dsu.find(i2)) {
						return false;
					}
				}
			}
			return true;
		}

		class DSU {

			private int[] groups = new int[26];

			private DSU() {
				for (int i = 0; i < groups.length; i++) {
					groups[i] = i;
				}
			}

			private int find(int key) {
				if (groups[key] == key) {
					return key;
				}
				return groups[key] = find(groups[key]);
			}

			private void union(int key1, int key2) {
				groups[find(key1)] = find(key2);
			}

		}
	}

	class Solution_ {
		public boolean equationsPossible(String[] equations) {
			Map<Node, Set<Node>> edges = new HashMap<>();
			for (String eq : equations) {
				if (parse(eq, edges)) {
					return false;
				}
			}
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (dfs(edges, new Node(ch, false), ch, new HashSet<>())) {
					return false;
				}
			}

			return true;
		}

		private boolean dfs(Map<Node, Set<Node>> edges, Node curr, char ch, Set<Node> visited) {
			if (visited.add(curr)) {
				for (Node next : edges.getOrDefault(curr, Collections.emptySet())) {
					if (next.ch == ch) {
						if (next.negate) {
							return true;
						}
					} else if (!curr.negate) {
						if (dfs(edges, next, ch, visited)) {
							return true;
						}
					}
				}
			}
			return false;
		}

		private boolean parse(String eq, Map<Node, Set<Node>> edges) {
			char ch1 = eq.charAt(0);
			char ch2 = eq.charAt(3);
			boolean negate = '!' == eq.charAt(1);
			if (ch1 == ch2 && negate) {
				return true;
			} else if (ch1 != ch2) {
				put(edges, new Node(ch2, false), new Node(ch1, negate));
				put(edges, new Node(ch1, false), new Node(ch2, negate));
			}
			return false;
		}

		private void put(Map<Node, Set<Node>> edges, Node key, Node node) {
			if (!edges.containsKey(key)) {
				edges.put(key, new HashSet<>());
			}
			edges.get(key).add(node);
		}

		private class Node {

			private final Character ch;
			private final boolean negate;

			private Node(char ch, boolean negate) {
				this.ch = ch;
				this.negate = negate;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Node node = (Node) o;
				return ch == node.ch &&
						negate == node.negate;
			}

			@Override
			public int hashCode() {
				return Objects.hash(ch, negate);
			}

			@Override
			public String toString() {
				return "Node{" +
						"ch=" + ch +
						", negate=" + negate +
						'}';
			}
		}
	}

}
