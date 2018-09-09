package com.leetcode.problems.hash.table.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomPickWithBlacklist {

	public Solution of(int N, int[] blacklist) {
		return new Solution(N, blacklist);
	}

	class Solution {

		private Random rnd = new Random();
		private List<int[]> intervals = new ArrayList<>();
		private int M;

		public Solution(int N, int[] blacklist) {
			Arrays.sort(blacklist);

			if (blacklist.length == 0) {
				intervals.add(new int[]{0, N - 1});
			} else {

				if (blacklist[0] != 0) {
					intervals.add(new int[]{0, blacklist[0] - 1});
				}
				for (int i = 0; i < blacklist.length; i++) {
					while (i + 1 < blacklist.length && blacklist[i] + 1 == blacklist[i + 1]) {
						i++;
					}
					if (i + 1 < blacklist.length) {
						intervals.add(new int[]{blacklist[i] + 1, blacklist[i + 1] - 1});
					}
				}
				if (blacklist[blacklist.length - 1] < N - 1) {
					intervals.add(new int[]{blacklist[blacklist.length - 1] + 1, N - 1});
				}
			}

			for (int[] i : intervals) {
				System.out.println(Arrays.toString(i));
			}

			this.M = N - blacklist.length;
		}

		public int pick() {
			int idx = rnd.nextInt(M);

			int i = 0;
			int sum = 0;

			while (i < intervals.size()) {
				int[] curr = intervals.get(i);
				if (sum + curr[1] - curr[0] + 1 <= idx) {
					sum += curr[1] - curr[0] + 1;
					i++;
				} else {
					break;
				}
			}

			int[] interval = intervals.get(i);
			idx -= sum;
			return interval[0] + idx;
		}
	}

}
