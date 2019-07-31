package com.algorithm.playground.leetcode.problems.lc100.lc140.lc142;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 */
public class LinkedListCycleII {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) {
	 * val = x;
	 * next = null;
	 * }
	 * }
	 */
	public class Solution {

		public ListNode detectCycle(ListNode head) {
			ListNode slow = head, fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					break;
				}
			}
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}

	}

	public class SolutionWithAdditionalMemory {

		public ListNode detectCycle(ListNode head) {
			Map<ListNode, ListNode> seen = new IdentityHashMap<>();
			for (; head != null; head = head.next) {
				if (seen.containsKey(head)) {
					return head;
				}
				seen.put(head, head);
			}
			return null;
		}

	}

}
