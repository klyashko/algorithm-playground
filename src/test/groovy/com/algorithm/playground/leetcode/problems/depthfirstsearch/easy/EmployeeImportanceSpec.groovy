package com.algorithm.playground.leetcode.problems.depthfirstsearch.easy


import spock.lang.Specification
import spock.lang.Unroll

import static EmployeeImportance.e

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
