package com.leetcode.problems.sort.hard

import com.leetcode.problems.sort.hard.InsertInterval.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.sort.Interval.valueOf as interval

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
