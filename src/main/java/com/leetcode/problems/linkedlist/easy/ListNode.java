package com.leetcode.problems.linkedlist.easy;

import java.util.List;

public class ListNode {

	public int val;
	public ListNode next;

	private ListNode(int x) {
		val = x;
	}

	public static ListNode valueOf(List<Integer> list) {
		if (list.isEmpty()) {
			return null;
		}
		ListNode head = new ListNode(list.get(0));
		ListNode curr = head;
		for (int i = 1; i < list.size(); i++) {
			ListNode next = new ListNode(list.get(i));
			curr.next = next;
			curr = next;
		}
		return head;
	}

	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
}
