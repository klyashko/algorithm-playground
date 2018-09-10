package com.leetcode.problems.hashtable.medium

import com.leetcode.problems.hashtable.medium.SortCharactersByFrequency.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SortCharactersByFrequencySpec extends Specification {

	@Unroll
	def "frequencySort"() {

		expect:

			new S().frequencySort(s) == output

		where:

			s              || output
			"tree"         || "eert"
			"cccaaa"       || "aaaccc"
			"Aabb"         || "bbAa"
			"loveleetcode" || "eeeellooctdv"

	}

}
