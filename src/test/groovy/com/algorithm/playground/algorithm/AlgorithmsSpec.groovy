package com.algorithm.playground.algorithm

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.*
import static com.algorithm.playground.algorithm.Algorithms.*

class AlgorithmsSpec extends Specification {

	@Repeat(10)
	def "minRepetitionSubstring_success"() {

		given:

			def p = nextString(nextInt(4, 10), AlgorithmsSpec.&withoutRepetitions)
			def s = p * nextInt(2, 10)

		expect:

			minRepetitionSubstring(s) == p

	}

	@Repeat(10)
	def "minRepetitionSubstring_failure"() {

		given:

			def s = nextString(nextInt(15, 50), AlgorithmsSpec.&withoutRepetitions)

		expect:

			minRepetitionSubstring(s) == s

	}

	private static boolean withoutRepetitions(String s) {
		for (int i = 1; i <= s.length() >> 1; i++) {
			if (s.length() % i == 0) {
				def tmp = s.substring(0, i) * (s.length() / i)
				if (tmp == s) {
					return false
				}
			}
		}
		return true
	}

	@Repeat(10)
	def "maxSumSubArray"() {

		given:

			def list = nextList(nextInt(50) + 1, { nextInt(-100, 100) })

		expect:

			sumSubArray(list) == maxSumSubArray(list as int[])

	}

	@SuppressWarnings("GroovyVariableNotAssigned")
	private static int sumSubArray(List<Integer> values) {
		int[] col = new int[values.size()]
		int max = Integer.MIN_VALUE
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j <= i; j++) {
				col[j] += values[i]
				max = Math.max(max, col[j])
			}
		}
		return max
	}

	@Repeat(10)
	def "kmpPatternSearch"() {

		given:

			def patternPart = nextString(nextInt(0, 5))
			def pattern = patternPart + nextString(nextInt(0, 3)) + patternPart.reverse()
			def str = nextString(pattern.length() << 1)
			def N = nextInt(1, 10)
			int offset = 0
			N.times {
				int idx = nextInt(offset, str.length())
				str = str.substring(0, idx) + pattern + str.substring(idx)
				offset = idx + pattern.length()
			}
			int expected = 0
			int idx = 0
			while ((idx = str.indexOf(pattern, idx)) != -1) {
				idx++
				expected++
			}

		expect:

			expected == kmpPatternSearch(str, pattern)

	}

}