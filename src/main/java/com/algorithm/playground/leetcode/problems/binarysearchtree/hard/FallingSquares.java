package com.algorithm.playground.leetcode.problems.binarysearchtree.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/falling-squares/description/
 */
public class FallingSquares {

	class Solution {

		public List<Integer> fallingSquares(int[][] positions) {
			TreeSet<Integer> coordinates = new TreeSet<>();
			for (int[] pos : positions) {
				coordinates.add(pos[0]);
				coordinates.add(pos[0] + pos[1] - 1);
			}
			Map<Integer, Integer> indexes = new HashMap<>();
			int idx = 0;
			for (Integer i : coordinates) {
				indexes.put(i, idx++);
			}

			int[] heights = new int[idx];
			List<Integer> ans = new ArrayList<>();
			for (int[] pos : positions) {
				int li = pos[0];
				int ri = li + pos[1] - 1;
				int hi = pos[1];

				int max = 0;
				for (int i = indexes.get(li); i <= indexes.get(ri); i++) {
					max = Math.max(max, heights[i]);
				}

				max += hi;

				for (int i = indexes.get(li); i <= indexes.get(ri); i++) {
					heights[i] = max;
				}

				max = 0;
				for (int h : heights) {
					max = Math.max(max, h);
				}
				ans.add(max);
			}
			return ans;
		}
	}

	class SegmentTreeSolution {

		public List<Integer> fallingSquares(int[][] positions) {
			Set<Integer> coords = new HashSet<>();
			for (int[] pos : positions) {
				coords.add(pos[0]);
				coords.add(pos[0] + pos[1] - 1);
			}
			List<Integer> sortedCoords = new ArrayList<>(coords);
			sortedCoords.sort(Integer::compareTo);

			Map<Integer, Integer> index = new HashMap<>();
			int t = 0;
			for (int coord : sortedCoords) {
				index.put(coord, t++);
			}
			SegmentTree tree = new SegmentTree(sortedCoords.size());
			int best = 0;
			List<Integer> ans = new ArrayList<>();

			for (int[] pos : positions) {
				int L = index.get(pos[0]);
				int R = index.get(pos[0] + pos[1] - 1);
				int h = tree.query(L, R) + pos[1];
				tree.update(L, R, h);
				best = Math.max(best, h);
				ans.add(best);
			}
			return ans;
		}

		class SegmentTree {
			int N, H;
			int[] tree, lazy;

			SegmentTree(int N) {
				this.N = N;
				this.H = 1;
				while ((1 << H) < N) {
					H++;
				}
				tree = new int[2 * N];
				lazy = new int[N];
			}

			private void apply(int x, int val) {
				tree[x] = Math.max(tree[x], val);
				if (x < N) {
					lazy[x] = Math.max(lazy[x], val);
				}
			}

			private void pull(int x) {
				while (x > 1) {
					x >>= 1;
					tree[x] = Math.max(tree[x * 2], tree[x * 2 + 1]);
					tree[x] = Math.max(tree[x], lazy[x]);
				}
			}

			private void push(int x) {
				for (int h = H; h > 0; h--) {
					int y = x >> h;
					if (lazy[y] > 0) {
						apply(y * 2, lazy[y]);
						apply(y * 2 + 1, lazy[y]);
						lazy[y] = 0;
					}
				}
			}

			private void update(int L, int R, int h) {
				L += N;
				R += N;
				int L0 = L, R0 = R;
				while (L <= R) {
					if ((L & 1) == 1) {
						apply(L++, h);
					}
					if ((R & 1) == 0) {
						apply(R--, h);
					}
					L >>= 1;
					R >>= 1;
				}
				pull(L0);
				pull(R0);
			}

			private int query(int L, int R) {
				L += N;
				R += N;
				int ans = 0;
				push(L);
				push(R);
				while (L <= R) {
					if ((L & 1) == 1) {
						ans = Math.max(ans, tree[L++]);
					}
					if ((R & 1) == 0) {
						ans = Math.max(ans, tree[R--]);
					}
					L >>= 1;
					R >>= 1;
				}
				return ans;
			}
		}
	}

}
