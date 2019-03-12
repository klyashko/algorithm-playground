package com.algorithm.playground.leetcode.problems.lc700.lc710.lc710

import com.algorithm.playground.leetcode.problems.lc700.lc710.lc710.RandomPickWithBlacklist as S
import spock.lang.Specification
import spock.lang.Unroll

class RandomPickWithBlacklistSpec extends Specification {

	@Unroll
	def "pick"() {

		given:

			def s = new S().of(n as int, blacklist as int[])
			def bl = blacklist.toSet()

		when:

			def r = s.pick()

		then:

			!(r in bl)
			r < n
			r >= 0

		where:

			n || blacklist
			4 || [2]
			3 || [1, 2]
			1 || []
	}

}
