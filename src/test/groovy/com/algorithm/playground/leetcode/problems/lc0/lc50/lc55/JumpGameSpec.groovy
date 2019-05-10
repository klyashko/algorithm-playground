package com.algorithm.playground.leetcode.problems.lc0.lc50.lc55

import com.algorithm.playground.leetcode.problems.lc0.lc50.lc55.JumpGame.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class JumpGameSpec extends Specification {

	@Unroll
	def "canJump"() {

		expect:

			new S().canJump(nums as int[]) == out

		where:

			nums            || out
			[2, 3, 1, 1, 4] || true
			[3, 2, 1, 0, 4] || false

	}

}
