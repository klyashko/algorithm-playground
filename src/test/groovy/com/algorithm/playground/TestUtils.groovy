package com.algorithm.playground

class TestUtils {

	private static final Random RND = new Random()

	static int getNextInt() {
		return RND.nextInt()
	}

	static int nextInt(int bound) {
		return RND.nextInt(bound)
	}

	static List<Integer> nextList(int size, int bound) {
		return (0..size).collect { RND.nextInt(bound) }
	}

	static int[] nextQueryInterval(int bound) {
		def lo = RND.nextInt(bound)
		def hi = RND.nextInt(bound - lo) + lo
		return [lo, hi]
	}

}
