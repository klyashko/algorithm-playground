package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.MinimumASCIIDeleteSumForTwoStrings.Solution
import spock.lang.Specification
import spock.lang.Unroll

class MinimumASCIIDeleteSumForTwoStringsSpec extends Specification {

	@Unroll
	def "minimumDeleteSum"() {

		expect:

			new Solution().minimumDeleteSum(s1, s2) == output

		where:

			s1       || s2     || output
//			"sea"    || "eat"  || 231
			"delete" || "leet" || 403
	}

}
