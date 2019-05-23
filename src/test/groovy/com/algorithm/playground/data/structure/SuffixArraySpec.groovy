package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextString

class SuffixArraySpec extends Specification {

	@Repeat(10)
	def "getFirst_success"() {

		given:

			def (String str, String pattern) = nextStringAndPattern
			def array = new SuffixArray(str)

		expect:

			str.indexOf(pattern) == array.getFirst(pattern)

	}

	@Repeat(10)
	def "getFirst_failure"() {

		given:

			def str = nextString(nextInt(2, 100))
			def pattern = nextString(str.length() << 2, { String it -> !str.contains(it) })
			def array = new SuffixArray(str)

		expect:

			array.getFirst(pattern) == -1

	}

	@Repeat(10)
	def "getLast_success"() {

		given:

			def (String str, String pattern) = nextStringAndPattern
			def array = new SuffixArray(str)

		expect:

			str.lastIndexOf(pattern) == array.getLast(pattern)

	}

	@Repeat(10)
	def "getLast_failure"() {

		given:

			def str = nextString(nextInt(2, 100))
			def pattern = nextString(str.length() << 2, { String it -> !str.contains(it) })
			def array = new SuffixArray(str)

		expect:

			array.getLast(pattern) == -1

	}

	@Repeat(10)
	def "contains_success"() {

		given:

			def (String str, String pattern) = nextStringAndPattern
			def array = new SuffixArray(str)

		expect:

			array.contains(pattern)

	}

	@Repeat(10)
	def "contains_failure"() {

		given:

			def str = nextString(nextInt(2, 100))
			def pattern = nextString(str.length() << 2, { String it -> !str.contains(it) })
			def array = new SuffixArray(str)

		expect:

			!array.contains(pattern)

	}

	@Repeat(10)
	def "count_success"() {

		given:

			def (String str, String pattern) = nextStringAndPattern
			int count = 0
			for (int idx = 0; idx < str.length(); idx++) {
				idx = str.indexOf(pattern, idx)
				if (idx != -1) {
					count++
				} else {
					break
				}
			}
			def array = new SuffixArray(str)

		expect:

			array.count(pattern) == count

	}

	@Repeat(10)
	def "count_failure"() {

		given:

			def str = nextString(nextInt(2, 100))
			def pattern = nextString(str.length() << 2, { String it -> !str.contains(it) })
			def array = new SuffixArray(str)

		expect:

			!array.count(pattern)

	}

	private static getNextStringAndPattern() {
		def str = nextString(nextInt(1, 100))
		def idx = nextInt(0, str.length())
		def len = nextInt(1, str.length() - idx)
		def pattern = str.substring(idx, idx + len)
		return [str, pattern]
	}

}