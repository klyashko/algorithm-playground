package com.algorithm.playground.data.structure;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HeavyLightDecomposition {

	private SegmentMaxTree[] trees;
	private int[] parents;
	private int[] level;
	private int[] head;
	private int[] indexes;
	private int[] treesIdx;
	private int[] offsets;

	public HeavyLightDecomposition(List<List<Integer>> tree, int[] values) {
		this.parents = new int[tree.size()];
		this.level = new int[tree.size()];
		this.head = new int[tree.size()];
		this.indexes = new int[tree.size()];
		this.treesIdx = new int[tree.size()];
		build(values, tree);
	}

	private void build(int[] values, List<List<Integer>> tree) {
		int[] heavy = new int[tree.size()];
		Arrays.fill(heavy, -1);
		parents[0] = -1;
		level[0] = 0;
		size(0, heavy, tree);

		TreeMap<Integer, Integer> sizes = new TreeMap<>();

		for (int n = 0, idx = 0; n < tree.size(); n++) {
			if (parents[n] == -1 || heavy[parents[n]] != n) {
				sizes.put(n, 0);
				for (int next = n; next != -1; next = heavy[next]) {
					head[next] = n;
					indexes[next] = idx++;
					sizes.merge(n, 1, Integer::sum);
				}
			}
		}

		trees = new SegmentMaxTree[sizes.size()];
		offsets = new int[sizes.size()];

		int offset = 0, idx = 0;
		for (Entry<Integer, Integer> e : sizes.entrySet()) {
			trees[idx] = new SegmentMaxTree(new int[e.getValue()]);
			offsets[idx] = offset;
			treesIdx[e.getKey()] = idx++;
			offset += e.getValue();
		}

		for (int i = 0; i < values.length; i++) {
			update(i, values[i]);
		}

	}

	public int max(int a, int b) {
		int max = 0;
		/** until both nodes on the same path */
		for (; head[a] != head[b]; a = parents[head[a]]) {
			/** if node b is deeper than a swap nodes */
			if (level[head[b]] > level[head[a]]) {
				int t = b;
				b = a;
				a = t;
			}
			int i = treesIdx[head[a]];
			max = Math.max(max, trees[i].query(indexes[head[a]] - offsets[i], indexes[a] - offsets[i]));
		}
		/** calculate from the same path */
		int i = treesIdx[head[a]];
		int left = Math.min(indexes[a], indexes[b]) - offsets[i];
		int right = Math.max(indexes[a], indexes[b]) - offsets[i];
		return Math.max(max, trees[i].query(left, right));
	}

	public void update(int idx, int val) {
		int i = treesIdx[head[idx]];
		trees[i].update(indexes[idx] - offsets[i], val);
	}

	private int size(int node, int[] heavy, List<List<Integer>> tree) {
		int size = 1, max = 0;
		for (Integer next : tree.get(node)) {
			if (next != parents[node]) {
				parents[next] = node;
				level[next] = level[node] + 1;
				int subtree = size(next, heavy, tree);
				if (max < subtree) {
					max = subtree;
					heavy[node] = next;
				}
				size += subtree;
			}
		}
		return size;
	}

}
