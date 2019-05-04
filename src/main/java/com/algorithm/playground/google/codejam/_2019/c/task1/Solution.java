package com.algorithm.playground.google.codejam._2019.c.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int a = console.nextInt();
				String[] other = new String[a];
				for (int i = 0; i < a; i++) {
					other[i] = console.next();
				}
				String ans = solve(other);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static String solve(String[] other) {
		List<String> rest = new ArrayList<>();
		if (other.length == 1) {
			rest.add(other[0]);
		}
		int len = 0;
		for (int i = 0; i < other.length; i++) {
			len = Math.max(len, other[i].length());
			for (int j = 0; j < other.length; j++) {
				if (j != i) {
					if (win(other[i], other[j])) {
						rest.add(other[i]);
						break;
					}
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < len << 1; i++) {
			int R = 0;
			int S = 0;
			int P = 0;
			for (String s : rest) {
				char ch = s.charAt(i % s.length());
				if (ch == 'R') {
					R++;
				} else if (ch == 'S') {
					S++;
				} else {
					P++;
				}
			}
			if (R != 0 && S != 0 && P != 0) {
				return "IMPOSSIBLE";
			} else {
				if (R != 0) {
					builder.append(S != 0 ? 'R' : 'P');
				} else if (P != 0) {
					builder.append('S');
				} else {
					builder.append('R');
				}
			}
		}
		return builder.toString();
	}

	private static boolean win(String m1, String m2) {
		for (int i = 0; i < 1000; i++) {
			char ch1 = m1.charAt(i % m1.length());
			char ch2 = m2.charAt(i % m2.length());
			if (firstIsBetter(ch1, ch2)) {
				return true;
			} else if (firstIsBetter(ch2, ch1)) {
				return false;
			}
		}
		return true;
	}

	private static boolean firstIsBetter(char ch1, char ch2) {
		if (ch1 == ch2) {
			return false;
		} else {
			switch (ch1) {
				case 'R':
					return ch2 == 'S';
				case 'S':
					return ch2 == 'P';
				default:
					return ch2 == 'R';
			}
		}
	}

}
