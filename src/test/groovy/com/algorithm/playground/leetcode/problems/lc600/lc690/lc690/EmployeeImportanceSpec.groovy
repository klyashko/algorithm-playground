package com.algorithm.playground.leetcode.problems.lc600.lc690.lc690

import com.algorithm.playground.leetcode.problems.lc600.lc690.lc690.EmployeeImportance
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.lc600.lc690.lc690.EmployeeImportance.e

class EmployeeImportanceSpec extends Specification {

	@Unroll
	def "getImportance"() {

		expect:

			new EmployeeImportance.Solution().getImportance(employees, id) == output

		where:

			employees     | id || output
			[e(1, 5, [2, 3]),
			 e(2, 3, []),
			 e(3, 3, [])] | 1  || 11

	}

}
