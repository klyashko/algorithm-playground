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

		private Queue<Integer> topQueue = new PriorityQueue<>();
		private Queue<Integer> bottomQueue = new PriorityQueue<>((a, b) -> b - a);
		private int k;

		public KthLargest(int k, int[] nums) {
			this.k = k - 1;
			int i = 0;
			for (; i < this.k && i < nums.length; i++) {
				topQueue.offer(nums[i]);
			}
			for (; i < nums.length; i++) {
				add(nums[i]);
			}
		}

		public int add(int val) {
			topQueue.offer(val);
			if (topQueue.size() > k) {
				bottomQueue.offer(topQueue.poll());
			}
			//noinspection ConstantConditions
			return bottomQueue.peek();
		}
	}

}
