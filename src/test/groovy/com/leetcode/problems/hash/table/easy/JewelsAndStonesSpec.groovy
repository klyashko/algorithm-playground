package com.leetcode.problems.hash.table.easy

import com.leetcode.problems.hash.table.easy.JewelsAndStones.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class JewelsAndStonesSpec extends Specification {

	@Unroll
	def "numJewelsInStones"() {

		expect:

			new S().numJewelsInStones(jewels, stones) == output

		where:

			jewels | stones    || output
			"aA"   | "aAAbbbb" || 3
			"z"    | "ZZ"      || 0

	}

}
