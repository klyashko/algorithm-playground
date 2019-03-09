package com.algorithm.playground.leetcode.problems.design.medium

import spock.lang.Specification
import spock.lang.Unroll

import static FlattenNestedListIterator.nestedInteger as i
import static FlattenNestedListIterator.nestedIterator as iterator

class FlattenNestedListIteratorSpec extends Specification {

	@Unroll
	def "nestedIterator"() {

		given:

			def iterator = iterator(list)
			def l = []

		when:

			iterator.each { l << it }

		then:

			l == values

		where:

			list                                     || values
			[i([i(1), i(1)]), i(2), i([i(1), i(1)])] || [1, 1, 2, 1, 1]
			[i([i(1), i([i(4), i([i(6)])])])]        || [1, 4, 6]

	}

}
