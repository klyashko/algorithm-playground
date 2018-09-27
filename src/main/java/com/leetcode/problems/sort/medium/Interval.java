package com.leetcode.problems.sort.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Interval {

	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public static Interval valueOf(int s, int e) {
		return new Interval(s, e);
	}

	public static List<Interval> valueOf(List<List<Integer>> values) {
		List<Interval> result = new ArrayList<>();
		for (List<Integer> l : values) {
			result.add(valueOf(l.get(0), l.get(1)));
		}
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Interval interval = (Interval) o;
		return start == interval.start &&
				end == interval.end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}

	@Override
	public String toString() {
		return "Interval{" +
				"start=" + start +
				", end=" + end +
				'}';
	}
}
