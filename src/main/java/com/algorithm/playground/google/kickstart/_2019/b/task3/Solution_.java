package com.algorithm.playground.google.kickstart._2019.b.task3;

import java.util.*;

public class Solution_ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DiverseSubarray solver = new DiverseSubarray();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++) {
			solver.solve(i, in);
		}
	}

	static class DiverseSubarray {
		int[][] sum;
		int[][] max_psum;

		void update(int level, int index) {
			sum[level][index] = sum[level + 1][2 * index] + sum[level + 1][2 * index + 1];
			max_psum[level][index] = Math.max(
					max_psum[level + 1][2 * index],
					sum[level + 1][2 * index] + max_psum[level + 1][2 * index + 1]
			);
		}

		void iset(int level, int index, int value) {
			sum[level][index] = value;
			max_psum[level][index] = value;
			while (level > 0) {
				--level;
				index /= 2;
				update(level, index);
			}
		}

		private int[] readIntArray(int size, Scanner in) {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			return arr;
		}

		public void solve(int testNumber, Scanner in) {
			int N = in.nextInt(), s = in.nextInt();
			int[] M = readIntArray(N, in);
			int depth = 18;
			sum = new int[depth + 1][];
			for (int l = 0; l <= depth; ++l) {
				sum[l] = new int[1 << l];
			}
			max_psum = new int[depth + 1][];
			for (int l = 0; l <= depth; ++l) {
				max_psum[l] = new int[1 << l];
			}

			Map<Integer, List<Integer>> occurrences = new HashMap<>();
			for (int n = 0; n < N; ++n) {
				if (!occurrences.containsKey(M[n])) {
					occurrences.put(M[n], new ArrayList<>());
				}
				occurrences.get(M[n]).add(n);
			}

			Map<Integer, Integer> offsets = new HashMap<>();
			for (int scene : occurrences.keySet()) {
				offsets.put(scene, 0);
			}

			for (int n = 0; n < (1 << depth); ++n) {
				iset(depth, n, 0);
			}
			for (int scene : occurrences.keySet()) {
				for (int j = 1; j <= s && j - 1 < occurrences.get(scene).size(); j++) {
					iset(depth, occurrences.get(scene).get(j - 1), +1);
				}
				if (occurrences.get(scene).size() >= s + 1) {
					iset(depth, occurrences.get(scene).get(s), -s);
				}
			}

			int answer = 0;
			for (int start = 0; start < N; ++start) {
				if (max_psum[0][0] > answer) answer = max_psum[0][0];

				int scene = M[start];
				int off = offsets.get(scene);
				iset(depth, start, 0);

				if (occurrences.get(scene).size() >= s + 1 + off) {
					iset(depth, occurrences.get(scene).get(s + off), +1);
				}
				if (occurrences.get(scene).size() >= s + 2 + off) {
					iset(depth, occurrences.get(scene).get(s + 1 + off), -s);
				}
				offsets.put(scene, off + 1);
			}
			System.out.println(String.format("Case #%s: %s", testNumber, answer));
		}

	}

}
