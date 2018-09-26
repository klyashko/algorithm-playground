package com.leetcode.problems.heap.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class FindMedianFromDataStream {

	class MedianFinder {

		private Queue<Integer> top = new PriorityQueue<>();
		private Queue<Integer> bottom = new PriorityQueue<>(Collections.reverseOrder());

		/**
		 * initialize your data structure here.
		 */
		public MedianFinder() { }

		public void addNum(int num) {
			double median = findMedian();
			if (num >= median) {
				if (top.size() > bottom.size()) {
					bottom.offer(top.poll());
				}
				top.offer(num);
			} else {
				if (top.size() < bottom.size()) {
					top.offer(bottom.poll());
				}
				bottom.offer(num);
			}
		}

		@SuppressWarnings("ConstantConditions")
		public double findMedian() {
			if (top.size() > bottom.size()) {
				return top.peek();
			} else if (top.size() < bottom.size()) {
				return bottom.peek();
			} else if (top.isEmpty() && bottom.isEmpty()) {
				return 0;
			} else {
				return (top.peek() + bottom.peek()) / 2.;
			}
		}
	}

}
