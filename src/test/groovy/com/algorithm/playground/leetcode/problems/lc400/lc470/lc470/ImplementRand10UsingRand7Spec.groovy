package com.algorithm.playground.leetcode.problems.lc400.lc470.lc470

import com.algorithm.playground.leetcode.problems.lc400.lc470.lc470.ImplementRand10UsingRand7.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ImplementRand10UsingRand7Spec extends Specification {

	@Unroll
	def "rand10"() {

		given:

			def s = new S()

		expect:

			100.times {
				def i = s.rand10()
				println(i)
				assert i > 0 && i < 11
			}

	}

}
