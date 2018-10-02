package com.leetcode.problems.binarysearchtree.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/my-calendar-ii/description/
 */
@SuppressWarnings("ConstantConditions")
public class MyCalendarII {

	class MyCalendarTwo {

		private LinkedList<Interval> intervals = new LinkedList<>();

		public MyCalendarTwo() {
			intervals.add(new Interval(0, Integer.MAX_VALUE, 0));
		}

		public boolean book(int start, int end) {
			int count = max(start, end - 1);
			if (count > 1) {
				return false;
			}
			insert(start, end);
			return true;
		}

		private void insert(int start, int end) {
			ListIterator<Interval> iterator = intervals.listIterator();
			while (iterator.hasNext()) {
				Interval curr = iterator.next();
				if (curr.start > end) {
					break;
				} else if (curr.end >= start) {
					int left = start - curr.start;
					int right = curr.end - end;
					if (left > 0) {
						iterator.set(new Interval(curr.start, start - 1, curr.count));
						iterator.add(new Interval(start, Math.min(end, curr.end), curr.count + 1));
					} else {
						iterator.set(new Interval(start - left, Math.min(end, curr.end), curr.count + 1));
					}
					if (right > 0) {
						iterator.add(new Interval(end + 1, curr.end, curr.count));
					}
				}
			}
		}

		private int max(int start, int end) {
			int max = 0;
			for (Interval interval : intervals) {
				if (interval.start <= start && interval.end >= end) {
					max = Math.max(max, interval.count);
				} else if (interval.start >= start && interval.start <= end) {
					max = Math.max(max, interval.count);
				} else if (interval.end >= start && interval.end <= end) {
					max = Math.max(max, interval.count);
				} else if (interval.start > end) {
					break;
				}
			}
			return max;
		}

		private class Interval {
			int start, end, count;

			public Interval(int start, int end, int count) {
				this.start = start;
				this.end = end;
				this.count = count;
			}

			@Override
			public String toString() {
				return "Interval{" +
						"start=" + start +
						", end=" + end +
						", count=" + count +
						'}';
			}
		}
	}

	/**
	 * Your MyCalendarTwo object will be instantiated and called as such:
	 * MyCalendarTwo obj = new MyCalendarTwo();
	 * boolean param_1 = obj.book(start,end);
	 */
	class MyCalendarTwo_ {

		private TreeSet<StartTime> intervals;

		public MyCalendarTwo_() {
			intervals = new TreeSet<>(Comparator.comparingInt(t -> t.start));
		}

		public boolean book(int start, int end) {
			int count = 0;
			for (StartTime time : intervals.headSet(new StartTime(end))) {
				for (Integer e : time.ends) {
					if (time.start >= start || e <= end) {
						count++;
					}
				}
			}
			if (count > 1) {
				return false;
			}
			StartTime time = new StartTime(start);
			if (intervals.contains(time)) {
				time = intervals.ceiling(time);
				time.ends.add(end);
			} else {
				time.ends.add(end);
				intervals.add(time);
			}

			return true;
		}

		private class StartTime {
			int start;
			List<Integer> ends = new ArrayList<>();

			public StartTime(int start) {
				this.start = start;
			}

			@Override
			public String toString() {
				return "StartTime{" +
						"start=" + start +
						", ends=" + ends +
						'}';
			}
		}
	}

}
