package com.algorithm.playground.leetcode.problems.lc300.lc330.lc330

import com.algorithm.playground.leetcode.problems.lc300.lc330.lc330.PatchingArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PatchingArraySpec extends Specification {

	@Unroll
	def "minPatches"() {

		expect:

			new S().minPatches(nums as int[], n) == out

		where:

			nums           | n          || out
			[1, 3]         | 6          || 1
			[1, 5, 10]     | 20         || 2
			[1, 2, 2]      | 5          || 0
			[2]            | 2          || 1
			[4]            | 4          || 2
			[]             | 7          || 3
			[]             | 32         || 6
			[1, 2, 31, 33] | 2147483647 || 28


	}

}
