package com.leetcode.problems.binarysearchtree.hard;

import com.leetcode.problems.sort.Interval;

import java.util.*;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
 */
public class DataStreamAsDisjointIntervals {

	/**
	 * Your SummaryRanges object will be instantiated and called as such:
	 * SummaryRanges obj = new SummaryRanges();
	 * obj.addNum(val);
	 * List<Interval> param_2 = obj.getIntervals();
	 */
	class SummaryRanges {

		private TreeMap<Integer, Interval> intervals;
		private Map<Integer, Interval> ends;

		/**
		 * Initialize your data structure here.
		 */
		public SummaryRanges() {
			intervals = new TreeMap<>();
			ends = new HashMap<>();
		}

		public void addNum(int val) {
			Map.Entry<Integer, Interval> entry = intervals.lowerEntry(val + 1);
			if (entry != null && entry.getValue().start <= val && entry.getValue().end >= val) {
				return;
			}
			Interval left = ends.get(val - 1);
			Interval right = intervals.get(val + 1);
			int li = val, ri = val;
			if (left != null) {
				li = left.start;
				intervals.remove(left.start);
				ends.remove(left.end);
			}
			if (right != null) {
				ri = right.end;
				ends.remove(right.end);
				intervals.remove(right.start);
			}
			Interval interval = new Interval(li, ri);
			ends.put(interval.end, interval);
			intervals.put(interval.start, interval);
		}

		public List<Interval> getIntervals() {
			return new ArrayList<>(intervals.values());
		}
	}

}
