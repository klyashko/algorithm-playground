package com.algorithm.playground.google.codejam._2018.qualification.task2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/00000000000000cb/00000000000079cb
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int[] nums = new int[console.nextInt()];
				for (int i = 0; i < nums.length; i++) {
					nums[i] = console.nextInt();
				}
				int ans = solve(nums);
				System.out.println(String.format("Case #%s: %s", test, ans == -1 ? "OK" : ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static int solve(int[] nums) {
		int[] odd = new int[nums.length >> 1];
		int[] even = new int[nums.length - odd.length];

		for (int i = 0; i < nums.length; i++) {
			int idx = i >> 1;
			if (i % 2 == 0) {
				even[idx] = nums[i];
			} else {
				odd[idx] = nums[i];
			}
		}

		Arrays.sort(odd);
		Arrays.sort(even);

		for (int i = 0; i < nums.length; i++) {
			int idx = i >> 1;
			if (i % 2 == 0) {
				nums[i] = even[idx];
			} else {
				nums[i] = odd[idx];
			}
			if (i != 0 && nums[i - 1] > nums[i]) {
				return i - 1;
			}
		}

		return -1;
	}

}
