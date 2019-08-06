package com.algorithm.playground.leetcode.problems.lc100.lc140.lc141;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.IdentityHashMap;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * <p>
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Follow up:
 * <p>
 * Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCycle {

	public class Solution {

		public boolean hasCycle(ListNode head) {
			if (head == null) {
				return false;
			}
			ListNode slow = head;
			ListNode fast = head.next;

			while (fast != null && fast.next != null) {
				if (slow == fast) {
					return true;
				}
				slow = slow.next;
				fast = fast.next.next;
			}
			return false;
		}

	}

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
	public class Solution_ {

		public boolean hasCycle(ListNode head) {
			IdentityHashMap<ListNode, ListNode> set = new IdentityHashMap<>();
			while (head != null) {
				if (set.putIfAbsent(head, head) != null) {
					return true;
				}
				head = head.next;
			}
			return false;
		}

	}

}
