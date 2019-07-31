package com.algorithm.playground.leetcode.problems.lc100.lc130.lc138;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * <p>
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {

	/**
	 * // Definition for a Node.
	 * class Node {
	 * public int val;
	 * public Node next;
	 * public Node random;
	 * <p>
	 * public Node() {}
	 * <p>
	 * public Node(int _val,Node _next,Node _random) {
	 * val = _val;
	 * next = _next;
	 * random = _random;
	 * }
	 * };
	 */
	class Solution {

		public Node copyRandomList(Node head) {
			return copy(head, new HashMap<>());
		}

		private Node copy(Node node, Map<Node, Node> copies) {
			if (node == null) {
				return null;
			} else if (copies.containsKey(node)) {
				return copies.get(node);
			}
			Node n = new Node();
			n.val = node.val;
			copies.put(node, n);
			n.next = copy(node.next, copies);
			n.random = copy(node.random, copies);
			return n;
		}

	}

}
