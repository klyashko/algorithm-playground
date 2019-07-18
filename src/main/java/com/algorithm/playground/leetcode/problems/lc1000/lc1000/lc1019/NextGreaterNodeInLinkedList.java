package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1019;

import com.algorithm.playground.leetcode.problems.utils.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {

	class Solution {
		public int[] nextLargerNodes(ListNode head) {
			int size = 0;
			for (ListNode curr = head; curr != null; curr = curr.next) {
				size++;
			}

			LinkedList<int[]> stack = new LinkedList<>();
			int[] ans = new int[size];

			for (int i = 0; i < size; i++) {
				while (!stack.isEmpty() && head.val > stack.peek()[1]) {
					ans[stack.pop()[0]] = head.val;
				}
				stack.push(new int[]{i, head.val});
				head = head.next;
			}

			return ans;
		}
	}

}
