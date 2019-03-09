package com.algorithm.playground.leetcode.problems.lc400.lc406

import com.algorithm.playground.leetcode.problems.lc400.lc406.QueueReconstructionByHeight.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class QueueReconstructionByHeightSpec extends Specification {

	@Unroll
	def "reconstructQueue"() {

		expect:

			new S().reconstructQueue(people as int[][]) == output as int[][]

		where:

			people                                           || output
			[[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]] || [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]

	}

}
