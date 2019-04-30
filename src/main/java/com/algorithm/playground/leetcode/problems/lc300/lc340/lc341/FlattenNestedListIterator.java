package com.algorithm.playground.leetcode.problems.lc300.lc340.lc341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class FlattenNestedListIterator {

	public static NestedIterator nestedIterator(List<NestedInteger> list) {
		return new FlattenNestedListIterator().createNestedIterator(list);
	}

	public static NestedInteger nestedInteger(Integer i) {
		return new NestedIntegerImpl(i);
	}

	public static NestedInteger nestedInteger(List<NestedInteger> list) {
		return new NestedIntegerImpl(list);
	}

	private NestedIterator createNestedIterator(List<NestedInteger> list) {
		return new NestedIterator(list);
	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		List<NestedInteger> getList();
	}

	public static class NestedIntegerImpl implements NestedInteger {

		private Integer i;
		private List<NestedInteger> list;

		NestedIntegerImpl(Integer i) {
			this.i = i;
		}

		NestedIntegerImpl(List<NestedInteger> list) {
			this.list = list;
		}

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		@Override
		public boolean isInteger() {
			return i != null;
		}

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		@Override
		public Integer getInteger() {
			return i;
		}

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		@Override
		public List<NestedInteger> getList() {
			return list;
		}
	}

	public class NestedIterator implements Iterator<Integer> {

		private LinkedList<NestedInteger> stack = new LinkedList<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}

		@Override
		public Integer next() {
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty()) {
				if (stack.peek().isInteger()) {
					return true;
				}
				NestedInteger ni = stack.pop();
				List<NestedInteger> list = ni.getList();
				if (list != null) {
					for (int i = list.size() - 1; i >= 0; i--) {
						stack.push(list.get(i));
					}
				}
			}
			return false;
		}
	}

}
