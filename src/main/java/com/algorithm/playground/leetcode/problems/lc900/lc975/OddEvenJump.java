package com.algorithm.playground.leetcode.problems.lc900.lc975;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/odd-even-jump/
 */
public class OddEvenJump {

	class Solution {
		public int oddEvenJumps(int[] A) {
			boolean[][] cache = new boolean[2][A.length];
			cache[0][A.length - 1] = true;
			cache[1][A.length - 1] = true;
			TreeMap<Integer, Integer> map = new TreeMap<>();
			map.put(A[A.length - 1], A.length - 1);
			int count = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				int curr = A[i];
				Map.Entry<Integer, Integer> minEntry = map.floorEntry(curr);
				if (minEntry != null && minEntry.getKey() <= curr) {
					cache[0][i] = cache[1][minEntry.getValue()];
				}

				Map.Entry<Integer, Integer> maxEntry = map.ceilingEntry(curr);
				if (maxEntry != null) {
					cache[1][i] = cache[0][maxEntry.getValue()];
					if (cache[1][i]) {
						count++;
					}
				}
				map.put(curr, i);
			}
			return count;
		}

	}

}
