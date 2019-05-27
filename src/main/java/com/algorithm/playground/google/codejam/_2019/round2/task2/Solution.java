package com.algorithm.playground.google.codejam._2019.round2.task2;

import java.util.*;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051679/00000000001461c8
 */
public class Solution {

	private static Scanner console;
	private static int failed;
	private static Random RND = new Random();

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			Solution.console = console;
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				solve();
			}
			System.out.println("DEBUG: total " + tests);
			System.out.println("DEBUG: failed " + failed);
			System.out.println("DEBUG: ratio " + ((double) failed / tests * 100.));
		}
	}

	private static void readSave() {
		String s = console.nextLine().trim();
		while (s.isEmpty()) {
			s = console.nextLine().trim();
		}
		if (s.startsWith("failed case:")) {
			failed++;
			console.nextInt();
		}
	}

	private static void solve() {
		List<Vase> all = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			all.add(new Vase(i + 1));
		}

		Collections.shuffle(all);

		for (int d = 1; d <= 60; d++) {
			readSave();
			Vase v = all.get(d % 15);
			put(v.id, nextToken());
		}

		Queue<Vase> queue = new PriorityQueue<>();
		for (int d = 61; d <= 80; d++) {
			console.nextInt();
			Vase v = all.get(d % all.size());
			v.size = read(v.id).length;
			v.time = d;
			queue.offer(v);
		}

		Vase[] candidates = new Vase[2];
		candidates[0] = queue.poll();
		candidates[1] = queue.poll();

		for (int d = 81; d <= 94; d++) {
			console.nextInt();
			Vase v = queue.poll();
			//noinspection ConstantConditions
			put(v.id, nextToken());
			v.size++;
			queue.offer(v);
		}

		for (int d = 95; d <= 96; d++) {
			console.nextInt();
			Vase v = candidates[d % candidates.length];
			v.size = read(v.id).length;
		}

		Vase candidate, other;
		if (candidates[0].size > candidates[1].size) {
			candidate = candidates[1];
			other = candidates[0];
		} else {
			candidate = candidates[0];
			other = candidates[1];
		}

		for (int d = 97; d <= 99; d++) {
			console.nextInt();
			put(other.id, nextToken());
		}
		console.nextInt();
		put(candidate.id, 100);
	}

	private static int nextToken() {
		return RND.nextInt(99) + 1;
	}

	private static void put(int v, int p) {
		System.out.println(v + " " + p);
	}

	private static int[] read(int v) {
		put(v, 0);
		int[] data = new int[console.nextInt()];
		for (int i = 0; i < data.length; i++) {
			data[i] = console.nextInt();
		}
		return data;
	}

	private static class Vase implements Comparable<Vase> {

		private int size, time, id;

		private Vase(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Vase o) {
			if (size != o.size) {
				return size - o.size;
			}
			return o.time - time;
		}

		@Override
		public String toString() {
			return "Vase{" +
					"size=" + size +
					", time=" + time +
					", id=" + id +
					'}';
		}
	}

}
