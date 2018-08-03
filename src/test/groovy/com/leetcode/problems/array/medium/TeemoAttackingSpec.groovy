package com.leetcode.problems.array.medium

import com.leetcode.problems.array.medium.TeemoAttacking.Solution
import spock.lang.Specification
import spock.lang.Unroll

class TeemoAttackingSpec extends Specification {

	@Unroll
	def "findPoisonedDuration"() {
		expect:

			time == new Solution().findPoisonedDuration(series as int[], duration)

		where:

			series    || duration || time
			[1, 4]    || 2        || 4
			[1, 2]    || 2        || 3
			[1, 2, 4] || 3        || 6
	}

}
