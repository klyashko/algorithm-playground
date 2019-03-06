package com.leetcode.problems.lc136

import com.leetcode.problems.lc100.lc136.SingleNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SingleNumberSpec extends Specification {

	@Unroll
	def "singleNumber"() {

		expect:

			new S().singleNumber(nums as int[]) == output

		where:

			nums            || output
			[2, 2, 1]       || 1
			[4, 1, 2, 1, 2] || 4

	}

}
