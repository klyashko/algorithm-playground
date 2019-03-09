package com.algorithm.playground.leetcode.problems.sort.hard;

import com.algorithm.playground.leetcode.problems.sort.Interval;

import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 */
public class InsertInterval {

	class Solution {
		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
			for (int i = 0; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if (curr.start > newInterval.end) {
					intervals.add(i, newInterval);
					return intervals;
				} else if (overlap(curr, newInterval)) {
					int count = 1, start = Math.min(curr.start, newInterval.start), end = Math.max(curr.end, newInterval.end);
					for (int j = i + 1; j < intervals.size(); j++) {
						Interval next = intervals.get(j);
						if (next.start > end) {
							break;
						}
						count++;
						end = Math.max(end, next.end);
					}
					for (; count > 0; count--) {
						intervals.remove(i);
					}
					intervals.add(i, new Interval(start, end));
					return intervals;
				}
			}
			intervals.add(newInterval);
			return intervals;
		}

		private boolean overlap(Interval interval1, Interval interval2) {
			if (interval1.start <= interval2.start && interval1.end >= interval2.start) {
				return true;
			} else if (interval1.start <= interval2.end && interval1.end >= interval2.end) {
				return true;
			} else {
				return interval2.start <= interval1.start && interval2.end >= interval1.start;
			}
		}
	}

}
