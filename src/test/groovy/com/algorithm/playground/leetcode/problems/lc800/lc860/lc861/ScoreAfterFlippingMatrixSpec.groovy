package com.algorithm.playground.leetcode.problems.lc800.lc860.lc861

import com.algorithm.playground.leetcode.problems.lc800.lc860.lc861.ScoreAfterFlippingMatrix.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ScoreAfterFlippingMatrixSpec extends Specification {

	@Unroll
	def "matrixScore"() {

		expect:

			new S().matrixScore(A as int[][]) == out

		where:

			A              || out
			[[0, 0, 1, 1],
			 [1, 0, 1, 0],
			 [1, 1, 0, 0]] || 39

	}

}
