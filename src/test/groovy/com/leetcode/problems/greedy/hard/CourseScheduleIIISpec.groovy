package com.leetcode.problems.greedy.hard

import com.leetcode.problems.greedy.hard.CourseScheduleIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleIIISpec extends Specification {

	@Unroll
	def "scheduleCourse"() {

		expect:

			new S().scheduleCourse(courses as int[][]) == output

		where:

			courses                  || output
//			[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]] || 3
//			[[1, 2], [2, 3]]                                      || 2
			[[5, 5], [4, 6], [2, 6]] || 2

	}

}
