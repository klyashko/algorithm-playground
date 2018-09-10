package com.leetcode.problems.hashtable.easy

import com.leetcode.problems.hashtable.easy.JewelsAndStones.Solution as S
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
