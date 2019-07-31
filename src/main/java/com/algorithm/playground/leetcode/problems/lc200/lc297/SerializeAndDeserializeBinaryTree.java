package com.algorithm.playground.leetcode.problems.lc200.lc297;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

import java.util.Arrays;
import java.util.Iterator;

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
			StringBuilder builder = new StringBuilder();
			toStringBuilder(root, builder);
			return builder.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty()) {
				return null;
			}
			Iterator<String> iterator = Arrays.asList(data.split(DELIMITER)).iterator();
			return valueOf(iterator);
		}

		private TreeNode valueOf(Iterator<String> values) {
			String value = values.next();
			if (NULL.equals(value)) {
				return null;
			}
			TreeNode node = new TreeNode(Integer.parseInt(value));
			node.left = valueOf(values);
			node.right = valueOf(values);
			return node;
		}

		private void toStringBuilder(TreeNode node, StringBuilder builder) {
			if (node == null) {
				builder.append(NULL).append(DELIMITER);
				return;
			}
			builder.append(node.val).append(DELIMITER);
			toStringBuilder(node.left, builder);
			toStringBuilder(node.right, builder);
		}
	}

}
