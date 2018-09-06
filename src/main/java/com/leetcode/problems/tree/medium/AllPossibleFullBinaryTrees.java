package com.leetcode.problems.tree.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 */
public class AllPossibleFullBinaryTrees {

	class Solution {
		public List<TreeNode> allPossibleFBT(int N) {
			if (N == 1) {
				return Collections.singletonList(new TreeNode(0));
			}
			List<TreeNode> list = new ArrayList<>();
			for (int i = 1; i < N - 1; i++) {
				List<TreeNode> left = allPossibleFBT(i);
				List<TreeNode> right = allPossibleFBT(N - i - 1);
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode node = new TreeNode(0);
						node.left = l;
						node.right = r;
						list.add(node);
					}
				}
			}
			return list;
		}
	}

}
