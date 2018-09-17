package com.leetcode.problems.breadthfirstsearch.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
 */
public class ShortestPathToGetAllKeys {

	class Solution {
		public int shortestPathAllKeys(String[] grid) {
			return 0;
		}

		private class Node {
			int r, c;
			Set<Character> keys = new HashSet<>();

			public Node(int r, int c) {
				this.r = r;
				this.c = c;
			}
		}
	}

}
