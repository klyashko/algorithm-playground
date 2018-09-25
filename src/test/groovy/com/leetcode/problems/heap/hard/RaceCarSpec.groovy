package com.leetcode.problems.heap.hard

import com.leetcode.problems.heap.hard.RaceCar.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RaceCarSpec extends Specification {

	@Unroll
	def "racecar"() {

		expect:

			new S().racecar(t) == output

		where:

			t    || output
			3    || 2
			6    || 5
			4    || 5
			26   || 13
			330  || 24
			5478 || 50
			5    || 7
			91   || 15
			411  || 26

	}

}
