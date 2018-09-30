package com.leetcode.problems.divideandconquer.hard

import com.leetcode.problems.divideandconquer.hard.CountOfSmallerNumbersAfterSelf.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CountOfSmallerNumbersAfterSelfSpec extends Specification {

	@Unroll
	def "countSmaller"() {

		expect:

			new S().countSmaller(nums as int[]) == output

		where:

			nums         || output
			[5, 2, 6, 1] || [2, 1, 1, 0]

	}

}
