package com.algorithm.playground.leetcode.problems.lc900.lc975;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/odd-even-jump/
 */
public class OddEvenJump {

	class Solution {
		public int oddEvenJumps(int[] A) {
			Boolean[][] cache = new Boolean[2][A.length];
			cache[0][A.length - 1] = true;
			cache[1][A.length - 1] = true;
			TreeMap<Integer, Integer> map = new TreeMap<>();
			map.put(A[A.length - 1], A.length - 1);
			int count = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				int curr = A[i];
				Integer min = map.floorKey(curr);
				if (min == null || min > curr) {
					cache[0][i] = false;
				} else {
					cache[0][i] = cache[1][map.get(min)];
				}

				Integer max = map.ceilingKey(curr);
				if (max == null) {
					cache[1][i] = false;
				} else {
					cache[1][i] = cache[0][map.get(max)];
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
