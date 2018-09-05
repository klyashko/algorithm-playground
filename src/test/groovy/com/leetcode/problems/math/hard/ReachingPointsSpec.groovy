package com.leetcode.problems.math.hard

import com.leetcode.problems.math.hard.ReachingPoints.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReachingPointsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "reachingPoints"() {

		expect:

			//noinspection GroovyAssignabilityCheck
			new S().reachingPoints(input) == output

		where:

			input        || output
			[1, 1, 3, 5] || true
//			[1, 1, 2, 2]                   || false
//			[1, 1, 1, 1]                   || true
//			[35, 13, 455955547, 420098884] || false

	}

}
