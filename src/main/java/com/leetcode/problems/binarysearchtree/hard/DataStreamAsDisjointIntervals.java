package com.leetcode.problems.binarysearchtree.hard;

import com.leetcode.problems.sort.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

		/**
		 * Initialize your data structure here.
		 */
		public SummaryRanges() {
			intervals = new TreeMap<>();
		}

		public void addNum(int val) {
			Map.Entry<Integer, Interval> entry = intervals.lowerEntry(val + 1);
			if (entry != null && insert(entry.getValue(), val)) {
				return;
			}
			entry = intervals.higherEntry(val);
			if (entry != null && insert(entry.getValue(), val)) {
				return;
			}
			intervals.put(val, new Interval(val, val));
		}

		private boolean insert(Interval interval, int val) {
			if (interval.start <= val && interval.end >= val) {
				return true;
			} else if (interval.start - 1 == val) {
				interval.start = val;
				Map.Entry<Integer, Interval> tmp = intervals.lowerEntry(val);
				if (tmp != null && tmp.getValue().end + 1 == interval.start) {
					tmp.getValue().end = interval.end;
					intervals.remove(interval.start);
				}
				return true;
			} else if (interval.end + 1 == val) {
				interval.end = val;
				Map.Entry<Integer, Interval> tmp = intervals.higherEntry(val);
				if (tmp != null && tmp.getValue().start - 1 == interval.end) {
					interval.end = tmp.getValue().end;
					intervals.remove(tmp.getKey());
				}
				return true;
			}
			return false;
		}

		public List<Interval> getIntervals() {
			return new ArrayList<>(intervals.values());
		}
	}

}
