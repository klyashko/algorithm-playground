package com.leetcode.problems.lc100.lc117

import com.leetcode.problems.lc100.lc117.PopulatingNextRightPointersInEachNodeII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PopulatingNextRightPointersInEachNodeIISpec extends Specification {

	@Unroll
	def "connect"() {

		given:

			def seven = new Node(val: 7)
			def three = new Node(val: 3, right: seven)
			def five = new Node(val: 5, next: seven)
			def four = new Node(val: 4, next: five)
			def two = new Node(val: 2, left: four, right: five, next: three)
			def expected = new Node(val: 1, left: two, right: three)

			def root = new Node(
					val: 1,
					left: new Node(
							val: 2,
							left: new Node(val: 4),
							right: new Node(val: 5)),
					right: new Node(
							val: 3,
							right: new Node(val: 7)
					))

		expect:

			new S().connect(root) == expected

	}

}
