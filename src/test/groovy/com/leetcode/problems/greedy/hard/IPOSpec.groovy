package com.leetcode.problems.greedy.hard

import com.leetcode.problems.greedy.hard.IPO.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class IPOSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "findMaximizedCapital"() {

		expect:

			new S().findMaximizedCapital(k, w, profits as int[], capital as int[]) == output

		where:

			k | w | profits   | capital   || output
			2 | 0 | [1, 2, 3] | [0, 1, 1] || 4
			3 | 0 | [1, 2, 3] | [0, 1, 2] || 6

	}

}
