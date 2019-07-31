package com.algorithm.playground.leetcode.problems.lc0.lc20.lc23;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLists {

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
			for (ListNode list : lists) {
				if (list != null) {
					queue.offer(list);
				}
			}
			ListNode curr = new ListNode(0), head = curr;
			while (!queue.isEmpty()) {
				ListNode n = queue.poll();
				curr.next = n;
				curr = n;
				if (n.next != null) {
					queue.offer(n.next);
				}
			}
			return head.next;
		}
	}

}
