package com.algorithm.playground.leetcode.problems.utils.linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

	public int val;
	public Node next;
	public Node random;

	public Node() {}

	public Node(int _val, Node _next, Node _random) {
		val = _val;
		next = _next;
		random = _random;
	}

	public static Node node(List<Integer> values, List<Integer> points) {
		if (values.isEmpty()) {
			return null;
		}
		Map<Integer, Node> nodes = new HashMap<>();
		Node head = new Node();
		Node curr = head;

		for (int i = 0; i < values.size(); i++) {
			nodes.put(i, curr);
			curr.val = values.get(i);
			if (i != values.size() - 1) {
				curr.next = new Node();
				curr = curr.next;
			}
		}

		for (int i = 0; i < points.size(); i++) {
			nodes.get(i).random = nodes.get(points.get(i));
		}

		return head;

	}

}
