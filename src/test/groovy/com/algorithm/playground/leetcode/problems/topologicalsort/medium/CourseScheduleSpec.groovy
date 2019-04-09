package com.algorithm.playground.leetcode.problems.topologicalsort.medium

import com.algorithm.playground.leetcode.problems.topologicalsort.medium.CourseSchedule.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleSpec extends Specification {

	@Unroll
	def "canFinish"() {

		expect:

			new S().canFinish(courses, prerequisites as int[][]) == output

		where:

			courses | prerequisites    || output
			2       | [[1, 0]]         || true
			2       | [[1, 0], [0, 1]] || false

	}

}
