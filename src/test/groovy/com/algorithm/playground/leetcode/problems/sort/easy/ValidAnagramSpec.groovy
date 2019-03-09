package com.algorithm.playground.leetcode.problems.sort.easy

import com.algorithm.playground.leetcode.problems.sort.easy.ValidAnagram.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ValidAnagramSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isAnagram"() {

		expect:

			new S().isAnagram(s, t) == output

		where:

			s         | t         || output
			"anagram" | "nagaram" || true
			"rat"     | "car"     || false

	}

}
