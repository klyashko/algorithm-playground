package com.algorithm.playground.leetcode.problems.lc900.lc900.lc903

import spock.lang.Specification
import spock.lang.Unroll

class ValidPermutationsForDISequenceSpec extends Specification {

	@Unroll
	def "numPermsDISequence"() {

		expect:

			new ValidPermutationsForDISequence.Solution().numPermsDISequence(str) == output

		where:

			str                                                  || output
			"DID"                                                || 5
			"IDDDIIDIIIIIIIIDIDID"                               || 853197538
			"IIDIIDDIDDDDIIDDIDIDIDDDDIDDDIIIIDDIDDDDIDIIDDIDID" || 997381513

	}

}
