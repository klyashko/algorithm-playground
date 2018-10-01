package com.leetcode.problems.unionfind.hard

import com.leetcode.problems.unionfind.hard.LongestConsecutiveSequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestConsecutiveSequenceSpec extends Specification {

	@Unroll
	def "longestConsecutive"() {

		expect:

			new S().longestConsecutive(nums as int[]) == output

		where:

			nums                   || output
			[100, 4, 200, 1, 3, 2] || 4

	}

}
