package com.algorithm.playground.leetcode.problems.lc900.lc925

import com.algorithm.playground.leetcode.problems.lc900.lc925.LongPressedName.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongPressedNameSpec extends Specification {

	@Unroll
	def "isLongPressedName"() {

		expect:

			new S().isLongPressedName(name, typed) == out

		where:

			name     | typed      || out
			"alex"   | "aaleex"   || true
			"saeed"  | "ssaaedd"  || false
			"leelee" | "lleeelee" || true

	}

}
