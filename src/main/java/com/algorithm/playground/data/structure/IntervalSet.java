package com.algorithm.playground.data.structure;

import java.util.*;

import static java.util.Collections.binarySearch;

public class IntervalSet implements Iterable<IntervalSet.Interval> {

	private List<Interval> intervals;

	public IntervalSet() {
		this.intervals = new ArrayList<>();
	}

	public void add(int le, int ri) {
		add(new Interval(le, ri));
	}

	public void add(Interval interval) {
		int idx = search(interval.le);
		if (idx < 0) {
			idx = Math.abs(idx) - 1;
			if (idx != 0 && interval.le - 1 == intervals.get(idx - 1).ri) {
				idx--;
			}
		}
		ListIterator<Interval> iterator = intervals.listIterator(idx);
		int le = interval.le - 1;
		int ri = interval.ri + 1;
		while (iterator.hasNext()) {
			Interval curr = iterator.next();
			if (curr.isIntersect(interval) || curr.isIntersect(le) || curr.isIntersect(ri)) {
				interval.le = Math.min(curr.le, interval.le);
				interval.ri = Math.max(curr.ri, interval.ri);
				iterator.remove();
			} else {
				break;
			}
		}
		intervals.add(idx, interval);
	}

	public Interval getOverlap(int point) {
		int idx = search(point);
		if (idx < 0 || idx >= intervals.size()) {
			return null;
		} else {
			return intervals.get(idx);
		}
	}

	public List<Interval> getOverlaps(int le, int ri) {
		return getOverlaps(new Interval(le, ri));
	}

	public List<Interval> getOverlaps(Interval interval) {
		int idx = search(interval.le);
		if (idx < 0) {
			idx = Math.abs(idx) - 1;
		}
		List<Interval> list = new ArrayList<>();
		for (; idx < intervals.size(); idx++) {
			Interval i = intervals.get(idx);
			if (i.isIntersect(interval)) {
				list.add(i);
			} else {
				break;
			}
		}
		return list;
	}

	private int search(int le) {
		//noinspection ComparatorMethodParameterNotUsed
		return binarySearch(intervals, null, (interval, ignored) -> {
			if (interval.isIntersect(le)) {
				return 0;
			}
			return interval.le - le;
		});
	}

	@Override
	public Iterator<Interval> iterator() {
		return intervals.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Interval i : intervals) {
			builder.append("\t\t").append(i.toString()).append(",\n");
		}
		builder.deleteCharAt(builder.lastIndexOf(","));
		return "IntervalSet{\n" +
				"\tintervals=[\n" + builder +
				"]}";
	}

	public static class Interval {
		private int le, ri;

		public Interval(int le, int ri) {
			this.le = le;
			this.ri = ri;
		}

		public int getLe() {
			return le;
		}

		public int getRi() {
			return ri;
		}

		boolean isIntersect(int i) {
			return le <= i && ri >= i;
		}

		boolean isIntersect(Interval i) {
			return isIntersect(i.le) || isIntersect(i.ri) || i.isIntersect(le) || i.isIntersect(ri);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Interval interval = (Interval) o;
			return le == interval.le && ri == interval.ri;
		}

		@Override
		public int hashCode() {
			return Objects.hash(le, ri);
		}

		@Override
		public String toString() {
			return "[" + le + ", " + ri + ']';
		}
	}

}
