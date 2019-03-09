package com.algorithm.playground.leetcode.problems.twopointers.medium

import com.algorithm.playground.leetcode.problems.twopointers.medium.LongestWordInDictionaryThroughDeleting.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestWordInDictionaryThroughDeletingSpec extends Specification {

	@Unroll
	def "findLongestWord"() {

		expect:

			new S().findLongestWord(str, list) == output

		where:

			str        | list                               || output
			"abpcplea" | ["ale", "apple", "monkey", "plea"] || "apple"
			"abpcplea" | ["a", "b", "c"]                    || "a"

	}

}
