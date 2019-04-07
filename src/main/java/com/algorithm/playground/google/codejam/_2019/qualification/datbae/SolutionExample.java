package com.algorithm.playground.google.codejam._2019.qualification.datbae;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionExample {

	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
//		int tests = sc.nextInt();
		int tests = 1;
		for (int test = 1; test <= tests; test++) {
			solve();
		}
	}

	public static void solve() {
//		int n = sc.nextInt();
//		int b = sc.nextInt();
//		int f = sc.nextInt();
		int n = 6;
		int b = 3;
		int f = 5;
		String[] guesses = new String[f];
		String[] ret = new String[f];
		for (int i = 0; i < f; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				System.out.println(String.format("j = %s, 1 << i = %s, j & (1 << i) = %s", j, 1 << i, j & (1 << i)));
				if ((j & (1 << i)) != 0) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			}
			System.out.println(sb);
			guesses[i] = sb.toString();
			System.out.flush();
//			ret[i] = sc.next();
//			if (ret[i].equals("-1")) {
//				throw new RuntimeException("got a bad verdict");
//			}
		}

		if (true) {
			System.exit(0);
		}

		List<Integer> ans = new ArrayList<>();
		int idx = 0;
		for (int i = 0; i < n; i++) {
			boolean bad = idx >= ret[0].length();
			for (int j = 0; !bad && j < f; j++) {
				if (guesses[j].charAt(i) != ret[j].charAt(idx)) {
					bad = true;
				}
			}
			if (bad) {
				ans.add(i);
			} else {
				idx++;
			}
		}
		if (ans.size() != b) {
			throw new RuntimeException("had " + ans.size() + " but wanted " + b);
		}
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i));
			if (i == ans.size() - 1) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
		}
		System.out.flush();
		String ss = sc.next();
		if (ss.equals("-1")) {
			throw new RuntimeException("WA");
		}
	}

}
