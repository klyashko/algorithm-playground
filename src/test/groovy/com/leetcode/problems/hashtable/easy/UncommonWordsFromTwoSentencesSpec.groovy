package com.leetcode.problems.hashtable.easy

import com.leetcode.problems.hashtable.easy.UncommonWordsFromTwoSentences.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class UncommonWordsFromTwoSentencesSpec extends Specification {

	@Unroll
	def "uncommonFromSentences"() {

		expect:

			new S().uncommonFromSentences(A, B) == output as String[]

		where:

			A                     | B                    || output
			"this apple is sweet" | "this apple is sour" || ["sweet", "sour"]
			"apple apple"         | "banana"             || ["banana"]

	}

}
