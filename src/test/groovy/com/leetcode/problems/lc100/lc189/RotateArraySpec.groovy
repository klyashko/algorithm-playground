package com.leetcode.problems.lc100.lc189

import com.leetcode.problems.lc189.RotateArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RotateArraySpec extends Specification {

	@Unroll
	def "rotate"() {

		given:

			def array = nums as int[]

		when:

			new S().rotate(array, k)

		then:

			array == out as int[]

		where:

			nums                  | k || out
			[1, 2, 3, 4, 5, 6, 7] | 3 || [5, 6, 7, 1, 2, 3, 4]
			[-1, -100, 3, 99]     | 2 || [3, 99, -1, -100]
			[1]                   | 0 || [1]
			[1]                   | 1 || [1]
			[-1]                  | 2 || [-1]
			[1, 2, 3, 4, 5, 6]    | 4 || [3, 4, 5, 6, 1, 2]


	}

}
