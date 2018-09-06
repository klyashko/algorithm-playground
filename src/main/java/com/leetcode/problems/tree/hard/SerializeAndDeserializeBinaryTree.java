package com.leetcode.problems.tree.hard;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
@SuppressWarnings("Duplicates")
public class SerializeAndDeserializeBinaryTree {

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	public class Codec {

		private final String NULL = "-";
		private final String DELIMITER = ",";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			List<String> list = new ArrayList<>();
			toList(root, list);
			return String.join(DELIMITER, list);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty()) {
				return null;
			}
			List<String> values = Arrays.asList(data.split(DELIMITER));
			return valueOf(values, new int[]{0});
		}

		private TreeNode valueOf(List<String> values, int[] idx) {
			int i = idx[0];
			idx[0]++;
			if (NULL.equals(values.get(i))) {
				return null;
			}
			TreeNode node = new TreeNode(Integer.valueOf(values.get(i)));
			node.left = valueOf(values, idx);
			node.right = valueOf(values, idx);
			return node;
		}

		private void toList(TreeNode node, List<String> list) {
			if (node == null) {
				list.add(NULL);
				return;
			}
			list.add(String.valueOf(node.val));
			toList(node.left, list);
			toList(node.right, list);
		}
	}

}
