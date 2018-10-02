package com.leetcode.problems.binarysearchtree.medium;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/my-calendar-ii/description/
 */
@SuppressWarnings("ConstantConditions")
public class MyCalendarII {

	/**
	 * Your MyCalendarTwo object will be instantiated and called as such:
	 * MyCalendarTwo obj = new MyCalendarTwo();
	 * boolean param_1 = obj.book(start,end);
	 */
	class MyCalendarTwo {

		private TreeSet<Time> intervals;

		public MyCalendarTwo() {
			intervals = new TreeSet<>(Comparator.comparingInt(t -> t.time));
		}

		public boolean book(int start, int end) {
			int max = 0;
			int count = 0;
			Time startTime = new Time(start, 1);
			Time endTime = new Time(end, -1);
			for (Time time : intervals.subSet(startTime, endTime)) {
				count += time.count;
				max = Math.max(max, Math.abs(count));
			}
			if (max > 1) {
				return false;
			}
			if (intervals.contains(startTime)) {
				Time time = intervals.ceiling(startTime);
				time.count++;
			} else {
				intervals.add(startTime);
			}

			if (intervals.contains(endTime)) {
				Time time = intervals.ceiling(endTime);
				time.count--;
			} else {
				intervals.add(endTime);
			}
			return true;
		}

		private class Time {
			int time, count;

			public Time(int time, int count) {
				this.time = time;
				this.count = count;
			}

			@Override
			public String toString() {
				return "Time{" +
						"time=" + time +
						", count=" + count +
						'}';
			}
		}
	}

}
