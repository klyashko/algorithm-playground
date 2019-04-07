package com.algorithm.playground.leetcode.problems.lc0.lc50.lc57

import com.algorithm.playground.leetcode.problems.lc0.lc50.lc57.InsertInterval.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.Interval.valueOf as interval

class InsertIntervalSpec extends Specification {

	@Unroll
	def "insert"() {

		expect:

			new S().insert(interval(values), interval(*new_interval)) == interval(output)

		where:

			values                                      | new_interval || output
			[[1, 3], [6, 9]]                            | [2, 5]       || [[1, 5], [6, 9]]
			[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]] | [4, 8]       || [[1, 2], [3, 10], [12, 16]]
			[[1, 5]]                                    | [0, 6]       || [[0, 6]]

	}

}
