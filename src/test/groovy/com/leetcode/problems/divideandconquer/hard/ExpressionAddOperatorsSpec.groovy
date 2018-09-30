package com.leetcode.problems.divideandconquer.hard

import com.leetcode.problems.divideandconquer.hard.ExpressionAddOperators.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ExpressionAddOperatorsSpec extends Specification {

	@Unroll
	def "addOperators"() {

		expect:

			new S().addOperators(nums, target) as Set == output as Set

		where:

			nums         | target || output
//			"123"        | 6      || ["1+2+3", "1*2*3"]
//			"232"        | 8      || ["2*3+2", "2+3*2"]
//			"105"        | 5      || ["1*0+5", "10-5"]
//			"00"         | 0      || ["0+0", "0-0", "0*0"]
			"3456237490" | 9191   || []

	}

}
