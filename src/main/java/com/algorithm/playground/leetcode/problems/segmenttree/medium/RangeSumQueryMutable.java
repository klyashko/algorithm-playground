package com.algorithm.playground.leetcode.problems.segmenttree.medium;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 */
public class RangeSumQueryMutable {

	public static NumArray numArray(int[] nums) {
		return new RangeSumQueryMutable().createNumArray(nums);
	}

	private NumArray createNumArray(int[] nums) {
		return new NumArray(nums);
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * obj.update(i,val);
	 * int param_2 = obj.sumRange(i,j);
	 */
	class NumArray {

		private int[] tree;
		private int len;

		public NumArray(int[] nums) {
			if (nums.length == 0) {
				tree = new int[0];
				return;
			}
			tree = new int[(1 << (32 - Integer.numberOfLeadingZeros(nums.length - 1))) * 2 - 1];
			len = nums.length - 1;
			build(nums, 0, len, 1);
		}

		public void update(int i, int val) {
			update(0, len, i, val, 1);
		}

		public int sumRange(int i, int j) {
			return query(0, len, i, j, 1);
		}

		private int update(int li, int ri, int i, int val, int idx) {
			if (li == ri && li == i) {
				tree[idx - 1] = val;
				return val;
			} else if (li > i || ri < i) {
				return tree[idx - 1];
			}
			int mid = li + (ri - li) / 2;
			int left = update(li, mid, i, val, idx * 2);
			int right = update(mid + 1, ri, i, val, idx * 2 + 1);
			int sum = left + right;
			tree[idx - 1] = sum;
			return sum;
		}

		private int query(int li, int ri, int i, int j, int idx) {
			if (li >= i && ri <= j) {
				return tree[idx - 1];
			} else if (ri < i || li > j) {
				return 0;
			}
			int mid = li + (ri - li) / 2;
			int left = query(li, mid, i, j, idx * 2);
			int right = query(mid + 1, ri, i, j, idx * 2 + 1);
			return left + right;
		}

		private int build(int[] nums, int li, int ri, int idx) {
			if (li == ri) {
				tree[idx - 1] = nums[li];
				return nums[li];
			}
			int mid = li + (ri - li) / 2;
			int left = build(nums, li, mid, idx * 2);
			int right = build(nums, mid + 1, ri, idx * 2 + 1);
			int sum = left + right;
			tree[idx - 1] = sum;
			return sum;
		}
	}

}
