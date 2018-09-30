package com.leetcode.problems.divideandconquer.hard

import com.leetcode.problems.divideandconquer.hard.ValidPermutationsForDISequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ValidPermutationsForDISequenceSpec extends Specification {

	@Unroll
	def "numPermsDISequence"() {

		expect:

			new S().numPermsDISequence(str) == output

		where:

			str                                                  || output
			"DID"                                                || 5
			"IDDDIIDIIIIIIIIDIDID"                               || 853197538
			"IIDIIDDIDDDDIIDDIDIDIDDDDIDDDIIIIDDIDDDDIDIIDDIDID" || 997381513

	}

}
