package com.algorithm.playground.leetcode.problems.sort.medium;

import com.algorithm.playground.leetcode.problems.sort.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {

	class Solution {
		public List<Interval> merge(List<Interval> intervals) {
			intervals.sort(Comparator.comparingInt(i -> i.start));
			List<Interval> result = new ArrayList<>();
			for (int i = 0; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				int start = curr.start, end = curr.end;
				for (int j = i + 1; j < intervals.size(); j++) {
					Interval next = intervals.get(j);
					if (next.start > end) {
						break;
					}
					end = Math.max(end, next.end);
					i = j;
				}
				result.add(new Interval(start, end));
			}
			return result;
		}
	}

}
