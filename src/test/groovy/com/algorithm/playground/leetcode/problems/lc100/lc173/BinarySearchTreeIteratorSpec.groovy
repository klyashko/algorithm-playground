package com.algorithm.playground.leetcode.problems.lc100.lc173

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.lc100.lc173.BinarySearchTreeIterator.bstIterator as iterator
import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class BinarySearchTreeIteratorSpec extends Specification {

	@Unroll
	def "bstIterator"() {

		given:

			def bsti = iterator(node(values))

		expect:

			[methods, results].transpose().each {
				method, result ->
					println("$method expect $result")
					assert bsti."$method"() == result
			}

		where:

			values    | methods                                                              || results
			[2, 1, 3] | ["hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"] || [true, 1, true, 2, true, 3, false]

	}

}
