package com.algorithm.playground.leetcode.problems.lc1000.lc1019;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {

	class Solution {
		public int[] nextLargerNodes(ListNode head) {
			List<ListNode> nodes = new ArrayList<>();
			ListNode curr = head;
			while (curr != null) {
				nodes.add(curr);
				curr = curr.next;
			}

			LinkedList<ListNode> stack = new LinkedList<>();
			int[] ans = new int[nodes.size()];

			for (int i = nodes.size() - 1; i >= 0; i--) {
				while (!stack.isEmpty() && nodes.get(i).val >= stack.peek().val) {
					stack.pop();
				}
				ans[i] = stack.isEmpty() ? 0 : stack.peek().val;
				stack.push(nodes.get(i));
			}

			return ans;
		}
	}

}
