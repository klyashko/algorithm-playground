package com.algorithm.playground.leetcode.problems.lc500.lc526

import com.algorithm.playground.leetcode.problems.lc500.lc526.BeautifulArrangement.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BeautifulArrangementSpec extends Specification {

	@Unroll
	def "countArrangement"() {

		expect:

			new S().countArrangement(N) == output

		where:

			N || output
			2 || 2

	}

}
