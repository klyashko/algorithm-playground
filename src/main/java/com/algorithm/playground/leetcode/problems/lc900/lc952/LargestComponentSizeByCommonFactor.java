package com.algorithm.playground.leetcode.problems.lc900.lc952;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
public class LargestComponentSizeByCommonFactor {

	class Solution {
		public int largestComponentSize(int[] A) {
			DSU dsu = new DSU(A.length);
			int[] graph = new int[10000];
			Arrays.fill(graph, -1);
			for (int i = 0; i < A.length; i++) {
				factorization(i, A[i], graph, dsu);
			}
			int[] counts = new int[A.length];
			int max = 0;
			for (int i = 0; i < A.length; i++) {
				int p = dsu.find(i);
				counts[p]++;
				max = Math.max(max, counts[p]);
			}
			return max;
		}

		private void factorization(int key, int val, int[] graph, DSU dsu) {
			int until = (int) (Math.sqrt(val) + 1);
			for (int i = 2; val != 1 && i <= until; i++) {
				if (val % i == 0) {
					while (val % i == 0) {
						val /= i;
					}
					union(key, i, graph, dsu);
				}
			}
			if (val > 1) {
				union(key, val, graph, dsu);
			}
		}

		private void union(int key, int factor, int[] graph, DSU dsu) {
			if (graph[factor] != -1) {
				dsu.union(graph[factor], key);
			} else {
				graph[factor] = key;
			}
		}

		private class DSU {

			private int[] sets;

			private DSU(int size) {
				this.sets = new int[size];
				for (int i = 0; i < sets.length; i++) {
					sets[i] = i;
				}
			}

			private int find(int key) {
				if (sets[key] == key) {
					return key;
				}
				return sets[key] = find(sets[key]);
			}

			private void union(int key1, int key2) {
				sets[find(key1)] = find(key2);
			}

		}
	}

}
