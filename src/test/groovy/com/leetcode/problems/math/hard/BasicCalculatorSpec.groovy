package com.leetcode.problems.math.hard

import com.leetcode.problems.math.hard.BasicCalculator.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BasicCalculatorSpec extends Specification {

	@Unroll
	def "calculate"() {

		expect:

			new S().calculate(s) == output

		where:

			s                     || output
			"1 + 1"               || 2
			"1 + 2 - (1 + 1)"     || 1
			" 2-1 + 2 "           || 3
			"(1+(4+5+2)-3)+(6+8)" || 23

	}

}
