package com.algorithm.playground.leetcode.problems.lc200.lc220.lc220

import com.algorithm.playground.leetcode.problems.lc200.lc220.lc220.ContainsDuplicateIII.SecondSolution as SS
import com.algorithm.playground.leetcode.problems.lc200.lc220.lc220.ContainsDuplicateIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ContainsDuplicateIIISpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "containsNearbyAlmostDuplicate"() {

		expect:

			new S().containsNearbyAlmostDuplicate(nums as int[], k, t) == output

		where:

			nums               | k | t          || output
			[1, 2, 3, 1]       | 3 | 0          || true
			[1, 0, 1, 1]       | 1 | 2          || true
			[1, 5, 9, 1, 5, 9] | 2 | 3          || false
			[0, 2147483647]    | 1 | 2147483647 || true
			[2, 1]             | 1 | 1          || true
			[0]                | 0 | 0          || false
			[]                 | 0 | 0          || false
			[1, 2]             | 0 | 1           | false

	}

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "containsNearbyAlmostDuplicate_second"() {

		expect:

			new SS().containsNearbyAlmostDuplicate(nums as int[], k, t) == output

		where:

			nums               | k | t          || output
			[1, 2, 3, 1]       | 3 | 0          || true
			[1, 0, 1, 1]       | 1 | 2          || true
			[1, 5, 9, 1, 5, 9] | 2 | 3          || false
			[0, 2147483647]    | 1 | 2147483647 || true
			[2, 1]             | 1 | 1          || true
			[0]                | 0 | 0          || false
			[]                 | 0 | 0          || false
			[1, 2]             | 0 | 1           | false

	}

}
