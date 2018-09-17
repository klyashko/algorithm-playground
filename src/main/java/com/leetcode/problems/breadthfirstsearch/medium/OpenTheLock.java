package com.leetcode.problems.breadthfirstsearch.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/open-the-lock/description/
 */
public class OpenTheLock {

	public static void main(String[] args) {
		char c = '0';
		for (int i = 0; i < 21; i++) {
			System.out.println(c);
//			c = (char) ((c + 1) % (':') + ('0' * ((c + 1) / ':')));
			c = ++c > '9' ? '0' : c;
		}
	}

	class Solution {
		public int openLock(String[] deadends, String target) {
			Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
			Set<String> visited = new HashSet<>();
			Queue<String> queue = new ArrayDeque<>();
			queue.add("0000");
			visited.add("0000");
			int step = -1;
			boolean found = false;

			while (!queue.isEmpty() && !found) {
				step++;
				int size = queue.size();
				while (size > 0) {
					String s = queue.poll();
					size--;
					//noinspection ConstantConditions
					if (s.equals(target)) {
						found = true;
						break;
					}
					if (deadendsSet.contains(s)) {
						continue;
					}
					StringBuilder builder = new StringBuilder(s);
					for (int i = 0; i < builder.length(); i++) {
						char ch = builder.charAt(i);
						builder.setCharAt(i, next(ch));
						String next = builder.toString();
						if (visited.add(next)) {
							queue.add(next);
						}
						builder.setCharAt(i, prev(ch));
						next = builder.toString();
						if (visited.add(next)) {
							queue.add(next);
						}
						builder.setCharAt(i, ch);
					}
				}
			}

			return found ? step : -1;
		}

		private char next(char ch) {
			return ++ch > '9' ? '0' : ch;
		}

		private char prev(char ch) {
			return --ch < '0' ? '9' : ch;
		}
	}

}
