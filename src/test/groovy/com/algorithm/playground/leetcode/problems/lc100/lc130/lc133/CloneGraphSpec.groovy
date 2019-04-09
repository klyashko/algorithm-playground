package com.algorithm.playground.leetcode.problems.lc100.lc130.lc133

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc133.CloneGraph.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CloneGraphSpec extends Specification {

	@Unroll
	def "cloneGraph"() {

		given:

			def one = new Node(val: 1)
			def two = new Node(val: 2)
			def three = new Node(val: 3)
			def four = new Node(val: 4)

			one.neighbors = [four, two]
			two.neighbors = [one, three]
			three.neighbors = [two, four]
			four.neighbors = [one, three]

		expect:

			equalsButNotSame(new S().cloneGraph(one), one, [] as Set<Node>)

	}
	private boolean equalsButNotSame(Node node1, Node node2, Set<Node> seen) {
		if (node1.val != node2.val || node1 == node2 || node1.neighbors.size() != node2.neighbors.size()) {
			return false
		}
		node1.neighbors.sort { it.val }
		node2.neighbors.sort { it.val }

		return ![node1.neighbors, node2.neighbors].transpose()
				.findAll { seen.add(it.get(0)) }
				.find { !equalsButNotSame(it.get(0), it.get(1), seen) }
	}

}
