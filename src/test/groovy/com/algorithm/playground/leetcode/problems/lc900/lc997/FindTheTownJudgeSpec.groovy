package com.algorithm.playground.leetcode.problems.lc900.lc997

import com.algorithm.playground.leetcode.problems.lc900.lc997.FindTheTownJudge.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FindTheTownJudgeSpec extends Specification {

	@Unroll
	def "findJudge"() {

		expect:

			new S().findJudge(N, trust as int[][]) == out

		where:

			N | trust                                    || out
			2 | [[1, 2]]                                 || 2
			3 | [[1, 3], [2, 3]]                         || 3
			3 | [[1, 3], [2, 3], [3, 1]]                 || -1
			3 | [[1, 2], [2, 3]]                         || -1
			4 | [[1, 3], [1, 4], [2, 3], [2, 4], [4, 3]] || 3

	}

}
