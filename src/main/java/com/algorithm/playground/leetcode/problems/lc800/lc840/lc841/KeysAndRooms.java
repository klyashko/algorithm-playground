package com.algorithm.playground.leetcode.problems.lc800.lc840.lc841;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class KeysAndRooms {

	class Solution {
		public boolean canVisitAllRooms(List<List<Integer>> rooms) {
			boolean[] seen = new boolean[rooms.size()];
			dfs(rooms, seen, 0);
			for (boolean b : seen) {
				if (!b) {
					return false;
				}
			}
			return true;
		}

		private void dfs(List<List<Integer>> rooms, boolean[] visited, int idx) {
			if (visited[idx]) {
				return;
			}
			visited[idx] = true;
			for (Integer i : rooms.get(idx)) {
				dfs(rooms, visited, i);
			}
		}
	}

	class IterativeSolution {
		public boolean canVisitAllRooms(List<List<Integer>> rooms) {
			boolean[] seen = new boolean[rooms.size()];

			int unvisited = seen.length;
			LinkedList<Integer> stack = new LinkedList<>();
			stack.push(0);

			while (!stack.isEmpty() && unvisited > 0) {
				Integer curr = stack.pop();
				if (seen[curr]) {
					continue;
				}
				for (Integer i : rooms.get(curr)) {
					stack.push(i);
				}
				seen[curr] = true;
				unvisited--;
			}

			return unvisited == 0;
		}
	}

}
