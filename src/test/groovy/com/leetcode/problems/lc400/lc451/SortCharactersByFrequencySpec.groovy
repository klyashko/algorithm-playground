package com.leetcode.problems.lc400.lc451

import com.leetcode.problems.lc400.lc451.SortCharactersByFrequency.Solution as S
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
