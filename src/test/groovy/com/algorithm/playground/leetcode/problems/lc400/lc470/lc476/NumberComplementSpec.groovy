package com.algorithm.playground.leetcode.problems.lc400.lc470.lc476

import com.algorithm.playground.leetcode.problems.lc400.lc470.lc476.NumberComplement.FastSolution as FS
import com.algorithm.playground.leetcode.problems.lc400.lc470.lc476.NumberComplement.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NumberComplementSpec extends Specification {

	@Unroll
	def "findComplement"() {

		expect:

			new S().findComplement(n) == output

		where:

			n || output
			5 || 2
			1 || 0
			4 || 3

	}

	@Unroll
	def "findComplement_fast"() {

		expect:

			new FS().findComplement(n) == output

		where:

			n || output
			5 || 2
			1 || 0
			4 || 3

	}

}
