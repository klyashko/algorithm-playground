package com.leetcode.problems.binarysearchtree.hard;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/range-module/description/
 */
public class RangeModule715 {

	/**
	 * Your RangeModule object will be instantiated and called as such:
	 * RangeModule obj = new RangeModule();
	 * obj.addRange(left,right);
	 * boolean param_2 = obj.queryRange(left,right);
	 * obj.removeRange(left,right);
	 */
	class RangeModule {

		private TreeMap<Integer, Integer> intervals = new TreeMap<>();

		public RangeModule() { }

		public void addRange(int left, int right) {
			Set<Integer> toDelete = new HashSet<>();
			for (Map.Entry<Integer, Integer> entry : intervals.headMap(right + 1).entrySet()) {
				Integer li = entry.getKey();
				Integer ri = entry.getValue();
				if (isOverlap(li, ri + 1, left, right)) {
					toDelete.add(li);
					left = Math.min(left, li);
					right = Math.max(right, ri);
				}
			}
			intervals.keySet().removeAll(toDelete);
			intervals.put(left, right);
		}

		public boolean queryRange(int left, int right) {
			Map.Entry<Integer, Integer> entry = intervals.lowerEntry(left + 1);
			return entry != null && entry.getValue() >= right - 1;
		}

		public void removeRange(int left, int right) {
			remove(intervals.lowerEntry(right), left, right);
			remove(intervals.lowerEntry(left), left, right);
		}

		private void remove(Map.Entry<Integer, Integer> entry, int left, int right) {
			if (entry != null && isOverlap(left, right, entry.getKey(), entry.getValue())) {
				intervals.remove(entry.getKey());
				if (entry.getKey() < left) {
					intervals.put(entry.getKey(), left - 1);
				}
				if (entry.getValue() > right) {
					intervals.put(right, entry.getValue());
				}
			}
		}

		private boolean isOverlap(int li1, int ri1, int li2, int ri2) {
			if (li1 <= li2 && ri2 <= ri1) {
				return true;
			} else if (li1 >= li2 && ri2 >= li1) {
				return true;
			} else {
				return li2 <= ri1 && ri2 >= ri1;
			}
		}
	}

}
