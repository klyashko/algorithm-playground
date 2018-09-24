package com.leetcode.problems.linkedlist.hard;

import com.leetcode.problems.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLists {

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists.length == 0) {
				return null;
			}
			Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
			for (ListNode list : lists) {
				if (list != null) {
					queue.offer(list);
				}
			}
			if (queue.isEmpty()) {
				return null;
			}
			ListNode curr = queue.poll();
			ListNode head = curr;
			//noinspection ConstantConditions
			if (curr.next != null) {
				queue.offer(curr.next);
			}
			while (!queue.isEmpty()) {
				ListNode n = queue.poll();
				//noinspection ConstantConditions
				curr.next = n;
				curr = n;
				//noinspection ConstantConditions
				if (n.next != null) {
					queue.offer(n.next);
				}
			}
			return head;
		}
	}

}
