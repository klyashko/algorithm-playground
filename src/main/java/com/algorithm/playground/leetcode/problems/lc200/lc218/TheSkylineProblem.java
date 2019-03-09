package com.algorithm.playground.leetcode.problems.lc200.lc218;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * https://leetcode.com/problems/the-skyline-problem/description/
 */
public class TheSkylineProblem {

	class Solution {
		public List<int[]> getSkyline(int[][] buildings) {
			LinkedList<Node> list = new LinkedList<>();
			list.add(new Node(0, Integer.MAX_VALUE, 0));
			for (int[] b : buildings) {
				insert(list, b);
			}

			List<int[]> ans = new ArrayList<>();
			int height = 0;
			for (Node curr : list) {
				if (curr.height > height) {
					ans.add(new int[]{curr.left, curr.height});
					height = curr.height;
				} else if (curr.height < height) {
					ans.add(new int[]{curr.left - 1, curr.height});
					height = curr.height;
				}

			}
			if (list.getLast().height > 0) {
				ans.add(new int[]{Integer.MAX_VALUE, 0});
			}
			return ans;
		}

		private void insert(LinkedList<Node> list, int[] building) {
			int li = building[0], ri = building[1], hi = building[2];
			ListIterator<Node> iterator = list.listIterator();
			while (iterator.hasNext()) {
				Node curr = iterator.next();
				if (curr.left > ri) {
					break;
				} else if (curr.right >= li && curr.height < hi) {
					int left = li - curr.left;
					int right = curr.right - ri;
					if (left > 0) {
						iterator.set(new Node(curr.left, li - 1, curr.height));
						iterator.add(new Node(li, Math.min(ri, curr.right), hi));
					} else {
						iterator.set(new Node(li - left, Math.min(ri, curr.right), hi));
					}
					if (right > 0) {
						iterator.add(new Node(ri + 1, curr.right, curr.height));
					}
				}
			}
		}

		private class Node {
			int left, right, height;

			public Node(int left, int right, int height) {
				this.left = left;
				this.right = right;
				this.height = height;
			}

			@Override
			public String toString() {
				return "Node{" +
						"left=" + left +
						", right=" + right +
						", height=" + height +
						'}';
			}
		}
	}

}
