package com.leetcode.problems.heap.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
@SuppressWarnings("ConstantConditions")
public class FindMedianFromDataStream {

	class MedianFinder {

		private Queue<Integer> top = new PriorityQueue<>();
		private Queue<Integer> bottom = new PriorityQueue<>(Collections.reverseOrder());

		/**
		 * initialize your data structure here.
		 */
		public MedianFinder() { }

		public void addNum(int num) {
			if (num >= findMedian()) {
				insert(top, bottom, num);
			} else {
				insert(bottom, top, num);
			}
		}

		public double findMedian() {
			if (top.size() > bottom.size()) {
				return top.peek();
			} else if (top.size() < bottom.size()) {
				return bottom.peek();
			} else {
				return top.isEmpty() ? 0 : (top.peek() + bottom.peek()) / 2.;
			}
		}

		private void insert(Queue<Integer> toInsert, Queue<Integer> other, int val) {
			if (toInsert.size() > other.size()) {
				other.offer(toInsert.poll());
			}
			toInsert.offer(val);
		}
	}

}
