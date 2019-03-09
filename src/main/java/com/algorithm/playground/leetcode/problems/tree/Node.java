package com.algorithm.playground.leetcode.problems.tree;

import java.util.List;

public class Node {

	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}

	public static Node valueOf(int _val, List<Node> _children) {
		return new Node(_val, _children);
	}

}
