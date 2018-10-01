package com.leetcode.problems.unionfind.hard

import com.leetcode.problems.unionfind.hard.LongestConsecutiveSequence.DSUSolution as DSUS
import com.leetcode.problems.unionfind.hard.LongestConsecutiveSequence.NaiveSolution as NS
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
			[1, 2, 0, 1]           || 3

	}

	@Unroll
	def "longestConsecutive_dsu"() {

		expect:

			new DSUS().longestConsecutive(nums as int[]) == output

		where:

			nums                   || output
			[100, 4, 200, 1, 3, 2] || 4
			[1, 2, 0, 1]           || 3

	}

	@Unroll
	def "longestConsecutive_naive"() {

		expect:

			new NS().longestConsecutive(nums as int[]) == output

		where:

			nums                   || output
			[100, 4, 200, 1, 3, 2] || 4
			[1, 2, 0, 1]           || 3

	}

}
