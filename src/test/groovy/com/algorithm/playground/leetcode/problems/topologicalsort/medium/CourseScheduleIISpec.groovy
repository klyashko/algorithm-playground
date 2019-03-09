package com.algorithm.playground.leetcode.problems.topologicalsort.medium

import com.algorithm.playground.leetcode.problems.topologicalsort.medium.CourseScheduleII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleIISpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "findOrder"() {

		expect:

			(new S().findOrder(courses, prerequisites as int[][]) as List<Integer>) in output

		where:

			courses | prerequisites                    || output
			2       | [[1, 0]]                         || [[0, 1]]
			4       | [[1, 0], [2, 0], [3, 1], [3, 2]] || [[0, 1, 2, 3], [0, 2, 1, 3]]

	}

}
