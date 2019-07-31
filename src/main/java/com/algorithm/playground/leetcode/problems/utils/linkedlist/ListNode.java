package com.algorithm.playground.leetcode.problems.utils.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListNode listNode = (ListNode) o;
		return val == listNode.val &&
				Objects.equals(next, listNode.next);
	}

	@Override
	public int hashCode() {
		return Objects.hash(val, next);
	}

	@Override
	public String toString() {
		List<String> values = new ArrayList<>();
		ListNode curr = this;
		while (curr != null) {
			values.add(Integer.toString(curr.val));
			curr = curr.next;
		}
		return "ListNode[" + String.join(", ", values) + ']';
	}
}
