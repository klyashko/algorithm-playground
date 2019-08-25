package com.algorithm.playground.google.kickstart._2019.e.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edb/00000000001707b8
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int d = console.nextInt();
				int s = console.nextInt();
				Slot[] slots = new Slot[s];
				double coding = 0;
				for (int i = 0; i < slots.length; i++) {
					slots[i] = new Slot(console.nextInt(), console.nextInt());
					coding += slots[i].coding;
				}

				Query[] queries = new Query[d];
				for (int i = 0; i < queries.length; i++) {
					queries[i] = new Query(i, console.nextInt(), console.nextInt());
				}

				String ans = solve(slots, queries, coding);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static String solve(Slot[] slots, Query[] queries, double totalCoding) {
		Arrays.sort(slots, (s1, s2) -> Double.compare(s1.coding * s2.eating, s2.coding * s1.eating));
		Arrays.sort(queries, Comparator.comparingDouble(q -> q.eating));

		double eating = 0;
		double coding = totalCoding;

		int n = slots.length;
		int nextInd = 0;
		char[] ans = new char[queries.length];
		for (Query query : queries) {
			while (nextInd < n && eating + slots[nextInd].eating <= query.eating) {
				eating += slots[nextInd].eating;
				coding -= slots[nextInd].coding;
				nextInd++;
			}

			double curEating = eating;
			double curCoding = coding;

			if (curEating <= query.eating && nextInd < n) {
				double req = query.eating - curEating;
				curCoding -= req * slots[nextInd].coding / slots[nextInd].eating;
				curEating += req;
			}

			if (curCoding >= query.coding && curEating >= query.eating) {
				ans[query.id] = 'Y';
			} else
				ans[query.id] = 'N';
		}
		return String.valueOf(ans);
	}

	private static class Slot {

		private int coding, eating;

		private Slot(int coding, int eating) {
			this.coding = coding;
			this.eating = eating;
		}

		@Override
		public String toString() {
			return "Slot{" +
					"coding=" + coding +
					", eating=" + eating +
					'}';
		}

	}

	private static class Query {

		private int id;
		private double coding, eating;

		private Query(int id, double coding, double eating) {
			this.id = id;
			this.coding = coding;
			this.eating = eating;
		}

		@Override
		public String toString() {
			return "Query{" +
					"id=" + id +
					", coding=" + coding +
					", eating=" + eating +
					'}';
		}

	}

}
