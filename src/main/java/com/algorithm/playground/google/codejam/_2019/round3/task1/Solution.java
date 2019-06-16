package com.algorithm.playground.google.codejam._2019.round3.task1;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051707/0000000000158f1a
 */
public class Solution {

	private static final long LEFT = 1;
	private static final long RIGHT = (long) 1e12;
	private static final long SIZE = (long) 1e10;

	private static Scanner console;
	private static TreeMap<Long, Long> intervals = new TreeMap<>();

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			Solution.console = console;
			int tests = console.nextInt();
			//Skip w
			console.nextInt();
			int wins = 0, loss = 0;
			for (int test = 1; test <= tests; test++) {
				intervals.clear();
				intervals.put(LEFT, RIGHT);
				long ans = play();
				if (ans == -1) {
					throw new RuntimeException("WA");
				} else if (ans == -2) {
					wins++;
				} else {
					loss++;
				}
			}
			System.out.println("DEBUG: wins=" + wins + " loss=" + loss);
		}

	}

	private static long play() {
		long p = console.nextLong();
		boolean done = false;
		for (; p > 0; p = console.nextLong()) {
			processMove(p);

			if (!done) {
				Entry<Long, Long> move = max();
				done = (size(move) / SIZE) <= 2;
				if (!done) {
					move(move);
					continue;
				}
			}
			int goodMoves = countTwoSizeMoves();
			if (goodMoves > 1) {
				if (goodMoves > 3) {
					if (moveInTheBeginningOfTwoSizeRange()) {
						continue;
					}
				}
				Long move = findOneSizeMove();
				if (move != null) {
					move(move);
					continue;
				}
			} else {
				int moves = intervals.size() + goodMoves;
				if ((moves & 1) == 0) {
					Entry<Long, Long> move = findTwoSizeMove();
					if (move != null) {
						move(move);
						continue;
					}
				} else {
					if (moveInTheBeginningOfTwoSizeRange()) {
						continue;
					}
				}
			}
			move(intervals.firstEntry().getKey());
		}
		return p;
	}

	private static boolean moveInTheBeginningOfTwoSizeRange() {
		Entry<Long, Long> move = findTwoSizeMove();
		if (move != null) {
			move(move.getKey());
			return true;
		}
		return false;
	}

	private static Long findOneSizeMove() {
		for (Entry<Long, Long> interval : intervals.entrySet()) {
			if (size(interval) / SIZE == 1) {
				return interval.getKey();
			}
		}
		return null;
	}

	private static Entry<Long, Long> max() {
		long maxScore = 0;
		Entry<Long, Long> max = null;
		for (Entry<Long, Long> interval : intervals.entrySet()) {
			long size = size(interval);
			if (size > maxScore) {
				max = interval;
				maxScore = size;
			}
		}
		return max;
	}

	private static Entry<Long, Long> findTwoSizeMove() {
		for (Entry<Long, Long> interval : intervals.entrySet()) {
			long size = size(interval);
			if (size / SIZE >= 2 && size % SIZE < SIZE - 1) {
				return interval;
			}
		}
		return null;
	}

	private static int countTwoSizeMoves() {
		int count = 0;
		for (Entry<Long, Long> interval : intervals.entrySet()) {
			count += size(interval) / SIZE == 2 ? 1 : 0;
		}
		return count;
	}

	private static void move(Entry<Long, Long> interval) {
		long middle = interval.getValue() + interval.getKey() >> 1;
		move(middle - (SIZE >> 1));
	}

	private static void move(long move) {
		processMove(move);
		System.out.println(move);
	}

	private static void processMove(long p) {
		Entry<Long, Long> curr = intervals.floorEntry(p);
		if (size(curr.getKey(), p - 1) >= SIZE) {
			intervals.replace(curr.getKey(), p - 1);
		} else {
			intervals.remove(curr.getKey());
		}

		long left = p + SIZE;
		if (size(left, curr.getValue()) >= SIZE) {
			intervals.put(left, curr.getValue());
		}
	}

	private static long size(Long left, Long right) {
		return right - left + 1;
	}

	private static long size(Entry<Long, Long> interval) {
		return size(interval.getKey(), interval.getValue());
	}

}
