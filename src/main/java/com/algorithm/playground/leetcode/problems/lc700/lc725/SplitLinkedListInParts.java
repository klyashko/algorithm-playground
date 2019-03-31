package com.algorithm.playground.leetcode.problems.lc700.lc725;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 */
public class SplitLinkedListInParts {

	class Solution {
		public ListNode[] splitListToParts(ListNode root, int k) {
			int size = size(root);
			int[] sizes = new int[k];
			Arrays.fill(sizes, size / k);
			for (int i = 0; i < size % k; i++) {
				sizes[i]++;
			}
			ListNode[] nodes = new ListNode[k];
			ListNode next = root;
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = next;

				for (int j = 0; j < sizes[i] - 1 && next != null; j++) {
					next = next.next;
				}
				if (next != null) {
					ListNode tmp = next.next;
					next.next = null;
					next = tmp;
				}
			}
			return nodes;
		}

		private int size(ListNode node) {
			int size = 0;
			while (node != null) {
				size++;
				node = node.next;
			}
			return size;
		}
	}

}
