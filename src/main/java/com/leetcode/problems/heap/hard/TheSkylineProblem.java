package com.leetcode.problems.heap.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/the-skyline-problem/description/
 */
public class TheSkylineProblem {

	class Solution {
		public List<int[]> getSkyline(int[][] buildings) {
			if (buildings.length == 0) {
				return Collections.emptyList();
			}
			List<int[]> ans = new ArrayList<>();
			int len = 0;
			for (int[] b : buildings) {
				len = Math.max(len, b[1]);
				if (len > 1_000_000) {
					break;
				}
			}
			if (len < 1_000_000) {
				int[] heights = new int[len + 2];
				for (int[] b : buildings) {
					for (int i = b[0]; i <= b[1]; i++) {
						heights[i] = Math.max(heights[i], b[2]);
					}
				}
				int height = 0;
				for (int i = 0; i < heights.length; i++) {
					int h = heights[i];
					if (h > height) {
						ans.add(new int[]{i, h});
						height = h;
					} else if (h < height) {
						ans.add(new int[]{i - 1, h});
						height = h;
					}

				}
			} else {
				/** Handling large integers  */
				int end = 0;
				List<int[]> tmp = new ArrayList<>();
				for (int[] b : buildings) {
					if (b[0] <= end) {
						tmp.add(b);
						end = Math.max(end, b[1]);
					} else {
						ans.addAll(getSkyline(tmp));
						tmp.clear();
						tmp.add(b);
						end = b[1];
					}
				}
				ans.addAll(getSkyline(tmp));
			}
			return ans;
		}

		private List<int[]> getSkyline(List<int[]> buildings) {
			List<int[]> dots = new ArrayList<>();
			for (int[] b : buildings) {
				dots.add(new int[]{b[0], b[2]});
				dots.add(new int[]{b[1], b[2]});
			}
			dots.sort(Comparator.comparingInt(p -> p[0]));
			LinkedList<Integer> stack = new LinkedList<>();
			List<int[]> ans = new ArrayList<>();
			stack.push(0);
			for (int[] p : dots) {
				//noinspection ConstantConditions
				if (p[1] > stack.peek()) {
					ans.add(new int[]{p[0], p[1]});
					stack.push(p[1]);
				} else if (p[1] == stack.peek()) {
					stack.pop();
					ans.add(new int[]{p[0], stack.peek()});
				} else {
					int idx = stack.lastIndexOf(p[1]);
					if (idx == -1) {
						int tmp = stack.pop();
						stack.push(p[1]);
						stack.push(tmp);
					} else {
						stack.remove(idx);
					}
				}
			}
			return ans;
		}
	}

	class Solution_ {
		public List<int[]> getSkyline(int[][] buildings) {
			LinkedList<Node> list = new LinkedList<>();
			list.add(new Node(0, Integer.MAX_VALUE, 0));
//			System.out.println(list);
			for (int[] b : buildings) {
				insert(list, b);
//				System.out.println(list);
			}

			List<int[]> ans = new ArrayList<>();
			int height = 0;
			for (Node curr : list) {
				if (curr.height > height) {
					ans.add(new int[]{curr.left, curr.height});
					height = curr.height;
				} else if (curr.height < height) {
					ans.add(new int[]{curr.left - 1, curr.height});
					height = curr.height;
				}

			}
			if (list.getLast().height > 0) {
				ans.add(new int[]{Integer.MAX_VALUE, 0});
			}
			return ans;
		}

		private void insert(LinkedList<Node> list, int[] building) {
			int li = building[0], ri = building[1], hi = building[2];
			ListIterator<Node> iterator = list.listIterator();
			while (iterator.hasNext()) {
				Node curr = iterator.next();
				if (curr.right < li) {
					continue;
				} else if (curr.left > ri) {
					break;
				} else {
					if (curr.height < hi) {
						int left = li - curr.left;
						int right = curr.right - ri;
						if (left > 0) {
							iterator.set(new Node(curr.left, li - 1, curr.height));
							iterator.add(new Node(li, Math.min(ri, curr.right), hi));
						} else {
							iterator.set(new Node(li - left, Math.min(ri, curr.right), hi));
						}
						if (right > 0) {
							iterator.add(new Node(ri + 1, curr.right, curr.height));
						}
					}
				}
			}
		}

		private class Node {
			int left, right, height;

			public Node(int left, int right, int height) {
				this.left = left;
				this.right = right;
				this.height = height;
			}

			@Override
			public String toString() {
				return "Node{" +
						"left=" + left +
						", right=" + right +
						", height=" + height +
						'}';
			}
		}
	}

}
