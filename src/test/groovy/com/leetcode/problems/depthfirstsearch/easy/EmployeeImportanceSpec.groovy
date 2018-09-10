package com.leetcode.problems.depthfirstsearch.easy

import com.leetcode.problems.depthfirstsearch.easy.EmployeeImportance.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.depthfirstsearch.easy.EmployeeImportance.e

class EmployeeImportanceSpec extends Specification {

	@Unroll
	def "getImportance"() {

		expect:

			new S().getImportance(employees, id) == output

		where:

			employees     | id || output
			[e(1, 5, [2, 3]),
			 e(2, 3, []),
			 e(3, 3, [])] | 1  || 11

	}

}
