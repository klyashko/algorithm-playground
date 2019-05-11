package com.algorithm.playground.google.kickstart._2019.b.task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050eda/0000000000119866
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//skip string length
				console.nextInt();
				int[][] queries = new int[console.nextInt()][2];
				String chars = console.next();
				for (int i = 0; i < queries.length; i++) {
					queries[i] = new int[]{console.nextInt(), console.nextInt()};
				}
				int ans = solve(chars, queries);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(String data, int[][] queries) {
		int[][] index = buildIndex(data);
		int count = 0;
		for (int[] query : queries) {
			if (query(index, query)) {
				count++;
			}
		}
		return count;
	}

	private static boolean query(int[][] index, int[] query) {
		int count = 0;
		int[] right = index[query[1]];
		int[] left = index[query[0] - 1];
		for (int i = 0; i < right.length && count < 2; i++) {
			int curr = right[i] - left[i];
			if (curr % 2 == 1) {
				count++;
			}
		}
		return count <= 1;
	}

	private static int[][] buildIndex(String data) {
		int[][] index = new int[data.length() + 1][];
		int[] curr = new int[26];
		index[0] = curr;
		for (int i = 0; i < data.length(); i++) {
			curr = Arrays.copyOf(curr, curr.length);
			int idx = data.charAt(i) - 'A';
			curr[idx]++;
			index[i + 1] = curr;
		}
		return index;
	}

}
