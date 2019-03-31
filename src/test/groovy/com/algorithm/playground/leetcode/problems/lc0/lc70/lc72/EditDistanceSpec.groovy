package com.algorithm.playground.leetcode.problems.lc0.lc70.lc72

import com.algorithm.playground.leetcode.problems.lc0.lc70.lc72.EditDistance.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class EditDistanceSpec extends Specification {

	@Unroll
	def "minDistance"() {

		expect:

			new S().minDistance(w1, w2) == out

		where:

			w1                                              | w2                     || out
			"horse"                                         | "ros"                  || 3
			"intention"                                     | "execution"            || 5
			""                                              | ""                     || 0
			"pneumonoultramicroscopicsilicovolcanoconiosis" | "ultramicroscopically" || 27

	}

}
