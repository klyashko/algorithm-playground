package com.algorithm.playground.leetcode.problems.lc200.lc258

import com.algorithm.playground.leetcode.problems.lc200.lc258.AddDigits.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class AddDigitsSpec extends Specification {

	@Unroll
	def "addDigits"() {

		expect:

			new S().addDigits(n) == output

		where:

			n  || output
			38 || 2

	}

}
