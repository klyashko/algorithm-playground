package com.algorithm.playground.google.codejam._2019.qualification.youcangoyourownway;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881da
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//skip grid size
				console.nextInt();
				String path = console.next().trim();
				String ans = solve(path);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static String solve(String path) {
		StringBuilder builder = new StringBuilder();
		for (char ch : path.toCharArray()) {
			char curr = ch == 'S' ? 'E' : 'S';
			builder.append(curr);
		}
		return builder.toString();
	}

}
