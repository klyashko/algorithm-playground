package com.leetcode.problems.hash.table.medium

import com.leetcode.problems.hash.table.medium.DailyTemperatures.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class DailyTemperaturesSpec extends Specification {

	@Unroll
	def "dailyTemperatures"() {

		expect:

			new S().dailyTemperatures(input as int[]) == output as int[]

		where:

			input                                     || output
			[73, 74, 75, 71, 69, 72, 76, 73]          || [1, 1, 4, 2, 1, 1, 0, 0]
			[89, 62, 70, 58, 47, 47, 46, 76, 100, 70] || [8, 1, 5, 4, 3, 2, 1, 1, 0, 0]

	}

}
