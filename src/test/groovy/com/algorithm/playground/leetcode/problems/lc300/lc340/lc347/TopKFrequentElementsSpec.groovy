package com.algorithm.playground.leetcode.problems.lc300.lc340.lc347

import com.algorithm.playground.leetcode.problems.lc300.lc340.lc347.TopKFrequentElements.BucketSortSolution as BSS
import com.algorithm.playground.leetcode.problems.lc300.lc340.lc347.TopKFrequentElements.Solution as S
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

	@Unroll
	def "topKFrequent_bucket_sort"() {

		expect:

			new BSS().topKFrequent(nums as int[], k) == output

		where:

			nums               | k || output
			[1, 1, 1, 2, 2, 3] | 2 || [1, 2]
			[1]                | 1 || [1]

	}

}
