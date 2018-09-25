package com.leetcode.problems.heap.easy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 */
public class KthLargestElementInAStream {

	public static KthLargest kthLargest(int k, int[] nums) {
		return new KthLargestElementInAStream().createKthLargest(k, nums);
	}

	private KthLargest createKthLargest(int k, int[] nums) {
		return new KthLargest(k, nums);
	}

	class KthLargest {

		private Queue<Integer> minQueue = new PriorityQueue<>();
		private int capacity;

		public KthLargest(int k, int[] nums) {
			this.capacity = k;
			for (int i : nums) {
				add(i);
			}
		}

		public int add(int val) {
			minQueue.add(val);
			if (minQueue.size() > capacity) {
				minQueue.poll();
			}
			//noinspection ConstantConditions
			return minQueue.peek();
		}
	}

}
