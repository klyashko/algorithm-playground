package com.algorithm.playground.leetcode.problems.breadthfirstsearch.easy


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.Node.valueOf as node

class NaryTreeLevelOrderTraversalSpec extends Specification {

	@Unroll
	def "levelOrder"() {

		expect:

			new NaryTreeLevelOrderTraversal.Solution().levelOrder(input) == output

		where:

			input || output
			node(1, [
					node(3, [
							node(5, []),
							node(6, [])
					]),
					node(2, []),
					node(4, []),
			])    || [[1],
					  [3, 2, 4],
					  [5, 6]]

	}

	@Unroll
	def "levelOrder_iterative"() {

		expect:

			new NaryTreeLevelOrderTraversal.IterativeSolution().levelOrder(input) == output

		where:

			input || output
			node(1, [
					node(3, [
							node(5, []),
							node(6, [])
					]),
					node(2, []),
					node(4, []),
			])    || [[1],
					  [3, 2, 4],
					  [5, 6]]

	}

}
