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

	static String nextString(int len, Closure<Boolean> filter) {
		String s = nextString(len)
		while (!filter(s)) {
			s = nextString(len)
		}
		return s
	}

	static String nextSubString(String str) {
		def idx = nextInt(str.length())
		def len = nextInt(str.length() - idx)
		return str[idx..idx + len]
	}

	static String nextStringWithPattern(String p, int count) {
		def s = nextString(nextInt(1, 5))
		for (int i = 0; i < count; i++) {
			s += p + nextString(nextInt(1, 5))
		}
		return s
	}

	static List<Integer> findAll(String s, String p) {
		def list = []
		for (int idx = 0; ; idx++) {
			idx = s.indexOf(p, idx)
			if (idx == -1) {
				break
			}
			list << idx
		}
		return list
	}

	static int count(String s, String p) {
		return findAll(s, p).size()
	}

	static int getNextInt() {
		return RND.nextInt()
	}

	static int getNextSmallInt() {
		return nextInt(100)
	}

	static int nextInt(int bound) {
		return RND.nextInt(bound)
	}

	static int nextInt(int leftBound, int rightBound) {
		if (leftBound == rightBound) {
			return leftBound
		}
		return RND.nextInt(rightBound - leftBound) + leftBound
	}

	static List<Integer> nextList(int size, int bound) {
		return nextList(size, { nextInt(bound) })
	}

	static List<Integer> nextList(int size, int leftBound, int rightBound) {
		return nextList(size, { nextInt(leftBound, rightBound) })
	}

	static <V> List<V> nextList(int size, Closure<V> closure) {
		return (0..size - 1).collect { closure() }
	}

	static <V> List<V> nextList(int size, Closure<V> closure, Closure<V> filter) {
		return (0..size - 1).collect {
			V val = closure()
			while (!filter(val)) {
				val = closure()
			}
			return val
		}
	}

	static int[] nextQueryInterval(int bound) {
		def lo = nextInt(bound)
		def hi = nextInt(lo, bound)
		return [lo, hi]
	}

	static <E> E nextElement(List<E> source) {
		return source.get(nextInt(source.size()))
	}

}
