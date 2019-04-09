package com.algorithm.playground.leetcode.problems.lc200.lc240.lc242

import com.algorithm.playground.leetcode.problems.lc200.lc240.lc242.ValidAnagram.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ValidAnagramSpec extends Specification {

	@Unroll
	def "isAnagram"() {

		expect:

			new S().isAnagram(s, t) == output

		where:

			s         | t         || output
			"anagram" | "nagaram" || true
			"rat"     | "car"     || false

	}

}
