package com.leetcode.problems.heap.medium

import com.leetcode.problems.heap.medium.TopKFrequentElements.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class TopKFrequentElementsSpec extends Specification {

	@Unroll
	def "topKFrequent"() {

		expect:

			new S().topKFrequent(nums as int[], k) == output

		where:

			nums               | k || output
			[1, 1, 1, 2, 2, 3] | 2 || [1, 2]
			[1]                | 1 || [1]

	}

}
