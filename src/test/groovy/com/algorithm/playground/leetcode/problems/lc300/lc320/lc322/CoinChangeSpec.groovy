package com.algorithm.playground.leetcode.problems.lc300.lc320.lc322

import com.algorithm.playground.leetcode.problems.lc300.lc320.lc322.CoinChange.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CoinChangeSpec extends Specification {

	@Unroll
	def "coinChange"() {

		expect:

			new S().coinChange(coins as int[], k) == out

		where:

			coins               | k    || out
			[1, 2, 5]           | 11   || 3
			[2]                 | 3    || -1
			[2, 5, 10, 1]       | 27   || 4
			[186, 419, 83, 408] | 6249 || 20

	}

}
