package com.algorithm.playground.leetcode.problems.string.easy

import com.algorithm.playground.leetcode.problems.string.easy.LongPressedName.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongPressedNameSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
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
