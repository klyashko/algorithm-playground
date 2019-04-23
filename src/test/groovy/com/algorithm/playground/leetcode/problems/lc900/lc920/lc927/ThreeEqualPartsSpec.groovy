package com.algorithm.playground.leetcode.problems.lc900.lc920.lc927

import com.algorithm.playground.leetcode.problems.lc900.lc920.lc927.ThreeEqualParts.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input: [1,0,1,0,1]
 * Output: [0,3]
 *
 * Input: [1,1,0,1,1]
 * Output: [-1,-1]
 *
 * 3 <= A.length <= 30000
 * A[i] == 0 or A[i] == 1
 */
class ThreeEqualPartsSpec extends Specification {

	@Unroll
	def "threeEqualParts"() {

		expect:

			new S().threeEqualParts(A as int[]) == out as int[]

		where:

			A                                                                                                                                                                                                                                                                                                            || out
			[1, 0, 1, 0, 1]                                                                                                                                                                                                                                                                                              || [0, 3]
			[1, 0, 1, 1, 0]                                                                                                                                                                                                                                                                                              || [-1, -1]
			[1, 1, 0, 1, 1]                                                                                                                                                                                                                                                                                              || [-1, -1]
			[0, 0, 0, 0, 0]                                                                                                                                                                                                                                                                                              || [0, 4]
			[0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0]                                                                                                                                                       || [-1, -1]
			[0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0] || [-1, -1]


	}

}
