package com.algorithm.playground.leetcode.problems.lc300.lc390.lc399

import com.algorithm.playground.leetcode.problems.lc300.lc390.lc399.EvaluateDivision.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class EvaluateDivisionSpec extends Specification {

	@Unroll
	def "calcEquation"() {

		expect:

			new S().calcEquation(equations as String[][], values as double[], queries as String[][]) == expected as double[]

		where:

			equations                | values     | queries                                                      || expected
			[["a", "b"], ["b", "c"]] | [2.0, 3.0] | [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]] || [6.0, 0.5, -1.0, 1.0, -1.0]

	}

}
