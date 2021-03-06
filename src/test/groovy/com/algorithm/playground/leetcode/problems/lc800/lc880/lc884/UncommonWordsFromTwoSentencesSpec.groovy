package com.algorithm.playground.leetcode.problems.lc800.lc880.lc884

import com.algorithm.playground.leetcode.problems.lc800.lc880.lc884.UncommonWordsFromTwoSentences.Solution as S
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
