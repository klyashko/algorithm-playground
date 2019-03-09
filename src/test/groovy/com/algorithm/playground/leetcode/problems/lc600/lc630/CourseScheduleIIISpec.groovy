package com.algorithm.playground.leetcode.problems.lc600.lc630

import com.algorithm.playground.leetcode.problems.lc600.lc630.CourseScheduleIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CourseScheduleIIISpec extends Specification {

	@Unroll
	def "scheduleCourse"() {

		expect:

			new S().scheduleCourse(courses as int[][]) == output

		where:

			courses                  || output
//			[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]                                                                                                                                                                                                 || 3
//			[[1, 2], [2, 3]]                                                                                                                                                                                                                                      || 2
			[[5, 5], [4, 6], [2, 6]] || 2
//			[[5, 15], [3, 19], [6, 7], [2, 10], [5, 16], [8, 14], [10, 11], [2, 19]]                                                                                                                                                                              || 5
//			[[645, 4702], [635, 6053], [295, 3541], [612, 3623], [646, 5874], [202, 1307], [272, 2512], [765, 5499], [239, 8199], [516, 8382], [61, 4930], [670, 2106], [153, 2310], [782, 988], [932, 5251], [109, 4862], [548, 9845], [146, 2650], [982, 1003]] || 17

	}

}
