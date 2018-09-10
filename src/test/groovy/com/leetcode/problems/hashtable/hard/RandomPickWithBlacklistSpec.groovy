package com.leetcode.problems.hashtable.hard

import com.leetcode.problems.hashtable.hard.RandomPickWithBlacklist as S
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
