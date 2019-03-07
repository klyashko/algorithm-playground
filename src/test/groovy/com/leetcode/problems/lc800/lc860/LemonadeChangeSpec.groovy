package com.leetcode.problems.lc800.lc860

import com.leetcode.problems.lc800.lc860.LemonadeChange.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LemonadeChangeSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "lemonadeChange"() {

		expect:

			new S().lemonadeChange(bills as int[]) == output

		where:

			bills              || output
			[5, 5, 5, 10, 20]  || true
			[5, 5, 10]         || true
			[10, 10]           || false
			[5, 5, 10, 10, 20] || false

	}

}
