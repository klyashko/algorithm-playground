package com.algorithm.playground.leetcode.problems.lc900.lc990;

import java.util.Arrays;

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
					dsu.union(eq.charAt(0), eq.charAt(3));
					len--;
				} else {
					equations[idx++] = eq;
				}
			}
			for (String eq : Arrays.copyOf(equations, len)) {
				if (eq.charAt(1) == '!') {
					if (dsu.find(eq.charAt(0)) == dsu.find(eq.charAt(3))) {
						return false;
					}
				}
			}
			return true;
		}

		class DSU {

			private int[] groups = new int[27];

			private int find(char key) {
				return find(key - 'a' + 1);
			}

			private int find(int key) {
				if (groups[key] == key || groups[key] == 0) {
					return key;
				}
				return groups[key] = find(groups[key]);
			}

			private void union(char key1, char key2) {
				groups[find(key1)] = find(key2);
			}

		}
	}

}
