package com.algorithm.playground

import static java.util.UUID.randomUUID

class TestUtils {

	private static final Random RND = new Random()

	static String getNextStringWithLettersOnly() {
		return nextString.replaceAll("[0-9]", "")
	}

	static String getNextString() {
		return randomUUID().toString().replaceAll("-", "")
	}

	static String nextString(int len) {
		String s = nextString
		while (s.length() < len) {
			s += nextString
		}
		return s[0..len - 1]
	}

	static int getNextInt() {
		return RND.nextInt()
	}

	static int nextInt(int bound) {
		return RND.nextInt(bound)
	}

	static int nextInt(int leftBound, int rightBound) {
		return RND.nextInt(rightBound - leftBound) + leftBound
	}

	static List<Integer> nextList(int size, int bound) {
		return (0..size).collect { nextInt(bound) }
	}

	static List<Integer> nextList(int size, int leftBound, int rightBound) {
		return (0..size).collect { nextInt(leftBound, rightBound) }
	}

	static <V> List<V> nextList(int size, Closure<V> closure) {
		return (0..size).collect { closure() }
	}

	static int[] nextQueryInterval(int bound) {
		def lo = nextInt(bound)
		def hi = nextInt(lo, bound)
		return [lo, hi]
	}

}
