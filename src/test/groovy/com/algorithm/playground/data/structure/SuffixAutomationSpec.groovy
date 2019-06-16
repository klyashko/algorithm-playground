package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.*

class SuffixAutomationSpec extends Specification {

	@Repeat(10)
	def "contains_success"() {

		given:

			def (str, sa) = nextSuffixAutomation

		expect:

			sa.contains(nextSubString(str))

	}

	@Repeat(10)
	def "contains_failure"() {

		given:

			def (str, sa) = nextSuffixAutomation
			def ss = nextString(nextInt(1, str.length()), { String s -> !str.contains(s) })

		expect:

			!sa.contains(ss)

	}

	def "contains_empty"() {

		given:

			def sa = new SuffixAutomation("")

		expect:

			!sa.contains(nextString(nextInt(1, 10)))

		and:

			sa.contains("")

	}

	@Repeat(10)
	def "lcs_substring"() {

		given:

			def (str, sa) = nextSuffixAutomation
			def lcs = nextSubString(str)

		expect:

			lcs == sa.lcs(lcs)

	}

	@Repeat(10)
	def "lcs_success"() {

		given:

			def (str, sa) = nextSuffixAutomation
			def lcs = nextSubString(str)
			def ss = nextString(nextInt(1, 10)) + lcs + nextString(nextInt(1, 10))

		when:

			def res = sa.lcs(ss)

		then:

			res
			str.contains(res)
			res.length() >= lcs.length()

	}

	@Repeat(10)
	def "lcs_failure"() {

		given:

			def s = nextString(1)
			def str = nextString(nextInt(1, 50)).replaceAll(s, "")
			def sa = new SuffixAutomation(str)

		expect:

			!sa.lcs(s)

	}

	def "lcs_empty"() {

		given:

			def sa = new SuffixAutomation("")

		expect:

			"" == sa.lcs(nextString(nextInt(1, 10)))

		and:

			"" == sa.lcs("")

	}

	@Repeat(10)
	def "count_distinct"() {

		given:

			def (str, sa) = nextSuffixAutomation

		expect:

			sa.countDistinct() == distinctSubstrings(str).size()

	}

	@Repeat(10)
	def "count_distinct_sizes"() {

		given:

			def (str, sa) = nextSuffixAutomation

		expect:

			sa.countDistinctSizes() == distinctSubstrings(str).sum { it.length() }

	}

	@Repeat(10)
	def "substring_success"() {

		given:

			def (str, sa) = nextSuffixAutomation

		expect:

			distinctSubstrings(str).sort().eachWithIndex { String s, int idx -> assert sa.substring(idx) == s }

	}

	def "substring_failure"() {

		given:

			def (str, sa) = nextSuffixAutomation
			def size = distinctSubstrings(str).size()
			def idx = nextInt(size, size << 1)

		expect:

			"" == sa.substring(idx)

	}

	@Repeat(10)
	def "minCyclicShift_success"() {

		given:

			def str = nextString
			def sa = new SuffixAutomation(str + str)

		expect:

			minLexRotation(str) == sa.minCyclicShift(str.length())

	}

	def "minCyclicShift_failure"() {

		given:

			def str = nextString
			def sa = new SuffixAutomation(str)

		expect:

			"" == sa.minCyclicShift(str.length() + nextInt(1, 10))

	}

	@Repeat(10)
	def "count_success"() {

		given:

			def pattern = nextString(nextInt(1, 5))
			def s = nextStringWithPattern(pattern, nextInt(1, 10))
			def sa = new SuffixAutomation(s)

		expect:

			count(s, pattern) == sa.count(pattern)

	}

	@Repeat(10)
	def "count_success_with_overlaps"() {

		given:

			def pattern = nextString(nextInt(1, 5)) * nextInt(2, 5)
			def s = pattern * nextInt(2, 10)
			def sa = new SuffixAutomation(s)

		expect:

			count(s, pattern) == sa.count(pattern)

	}

	@Repeat(10)
	def "count_failure"() {

		given:

			def pattern = nextString(nextInt(1, 5))
			def s = nextString.replaceAll(pattern, "")
			def sa = new SuffixAutomation(s)

		expect:

			!sa.count(pattern)

	}

	@Repeat(10)
	def "firstIndexOf_success"() {

		given:

			def p = nextString(nextInt(2, 5))
			def str = nextString(nextInt(2, 5)) + (p * nextInt(1, 10)) + nextString(nextInt(2, 5))
			def sa = new SuffixAutomation(str)

		expect:

			str.indexOf(p) == sa.firstIndexOf(p)

	}

	@Repeat(10)
	def "firstIndexOf_failure"() {

		given:

			def p = nextString(nextInt(2, 5))
			def str = nextString.replaceAll(p, "")
			def sa = new SuffixAutomation(str)

		expect:

			-1 == sa.firstIndexOf(p)

	}

	@Repeat(10)
	def "allIndexesOf_success"() {

		given:

			def p = nextString(nextInt(2, 5))
			def str = nextString(nextInt(2, 5)) + (p * nextInt(1, 10)) + nextString(nextInt(2, 5))
			def sa = new SuffixAutomation(str)

		expect:

			findAll(str, p) == sa.allIndexesOf(p)

	}

	def "allIndexesOf_failure"() {

		given:


			def p = nextString(nextInt(2, 5))
			def str = nextString.replaceAll(p, "")
			def sa = new SuffixAutomation(str)

		expect:

			sa.allIndexesOf(p).isEmpty()

	}

	private static String minLexRotation(String s) {
		int len = s.length()
		s += s
		return (0..len - 1).collect { s.substring(it, it + len) }.min()

	}

	private static Set<String> distinctSubstrings(String s) {
		def result = new HashSet<String>()
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				result.add(s.substring(i, j))
			}
		}
		return result
	}

	private static getNextSuffixAutomation() {
		def str = nextString
		def sa = new SuffixAutomation(str)
		return [str, sa]
	}

	private static String getNextString() {
		return nextString(nextInt(1, 50))
	}

}