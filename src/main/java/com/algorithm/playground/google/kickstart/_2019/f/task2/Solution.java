package com.algorithm.playground.google.kickstart._2019.f.task2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edc/00000000001864bc
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				int s = console.nextInt();
				@SuppressWarnings("unchecked")
				Set<Integer>[] skills = new HashSet[n];
				for (int i = 0; i < n; i++) {
					int size = console.nextInt();
					skills[i] = new HashSet<>();
					for (int j = 0; j < size; j++) {
						skills[i].add(console.nextInt());
					}
				}
				int ans = solve(skills);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static int solve(Set<Integer>[] skills) {
		int count = 0;
		for (int i = 0; i < skills.length; i++) {
			Set<Integer> curr = skills[i];
			for (int j = 0; j < skills.length; j++) {
				if (i != j && !skills[j].containsAll(curr)) {
					count++;
				}
			}
		}
		return count;
	}

}
