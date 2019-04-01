package com.algorithm.playground.leetcode.problems.lc200.lc220.lc224

import com.algorithm.playground.leetcode.problems.lc200.lc220.lc224.BasicCalculator.Solution as S
import com.algorithm.playground.leetcode.problems.lc200.lc220.lc224.BasicCalculator.SolutionFast as SF
import spock.lang.Specification
import spock.lang.Unroll

class BasicCalculatorSpec extends Specification {

	@Unroll
	def "calculate"() {

		expect:

			new S().calculate(s) == output

		where:

			s                                         || output
			"(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))" || 23
			"1-(5)"                                   || -4
			"2-4-(8+2-6+(8+4-(1)+8-10))"              || -15
			"(1 + 1)"                                 || 2
			"1 + 1"                                   || 2
			"1 + 2 - (1 + 1)"                         || 1
			" 2-1 + 2 "                               || 3
			"(1+(4+5+2)-3)+(6+8)"                     || 23
			"(1+(4+5+2)-3)"                           || 9
			"(1+(4+5+2))"                             || 12

	}

	@Unroll
	def "calculateFast"() {

		expect:

			new SF().calculate(s) == output

		where:

			s                                         || output
			"(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))" || 23
			"1-(5)"                                   || -4
			"2-4-(8+2-6+(8+4-(1)+8-10))"              || -15
			"(1 + 1)"                                 || 2
			"1 + 1"                                   || 2
			"1 + 2 - (1 + 1)"                         || 1
			" 2-1 + 2 "                               || 3
			"(1+(4+5+2)-3)+(6+8)"                     || 23
			"(1+(4+5+2)-3)"                           || 9
			"(1+(4+5+2))"                             || 12

	}

}
