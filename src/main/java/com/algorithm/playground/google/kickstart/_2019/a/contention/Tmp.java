package com.algorithm.playground.google.kickstart._2019.a.contention;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class Tmp {

	public static void main(String[] args) {
		Random rnd = new Random();
		int RIGHT = 1_000_001;
		int ittr = 0;
		long fastTime = 0;
		long rightTime = 0;
		while (true) {
//                int n = rnd.nextInt(30000) + 1
			int n = 30000;
//                int n = rnd.nextInt(100) + 1
//                int n = rnd.nextInt(5) + 1
			int[][] intervals = new int[n][];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int li = rnd.nextInt(RIGHT) + 1;
				int ri = rnd.nextInt(RIGHT - li + 1) + li;
				max = Math.max(max, ri + 1);
				intervals[i] = new int[]{li, ri};
			}

			long start = currentTimeMillis();
			int right = Solution_.solve(intervals, max + 1);
			rightTime += currentTimeMillis() - start;

			start = currentTimeMillis();
			int fast = Solution.solve(intervals, max + 1);
			fastTime += currentTimeMillis() - start;
			if (right != fast) {
				System.out.println("Right: " + right);
				System.out.println("Fast: " + fast);
				System.out.println("Data:");
				for (int[] ints : intervals) {
					System.out.println(Arrays.toString(ints));
				}
				break;
			}

			if (ittr % 100 == 0) {
				System.out.println("Iterations " + ittr + " completed. Average time " + fastTime / 100. + " ms. Base line " + rightTime / 100. + " ms.");
				fastTime = 0;
				rightTime = 0;
			}
			ittr++;
		}
	}

}

