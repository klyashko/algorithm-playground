package com.algorithm.playground.leetcode.problems.lc800.lc860.lc862

import com.algorithm.playground.leetcode.problems.lc800.lc860.lc862.ShortestSubarrayWithSumAtLeastK.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ShortestSubarrayWithSumAtLeastKSpec extends Specification {

	@Unroll
	def "shortestSubarray"() {

		expect:

			new S().shortestSubarray(A as int[], K) == output

		where:

			A                       | K  || output
//			[1]                     | 1   || 1
//			[1, 2]                  | 4   || -1
//			[2, -1, 2]              | 3   || 3
//			[2, -1, 2, 1]           | 3   || 2
//			[77, 19, 35, 10, -14]   | 19  || 1
//			[48, 99, 37, 4, -31]    | 140 || 2
			[-28, 81, -20, 28, -29] | 89 || 3

	}

}
