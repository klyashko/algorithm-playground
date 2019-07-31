package com.algorithm.playground.leetcode.problems.lc100.lc130.lc138

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc138.CopyListWithRandomPointer.Solution as S
import com.algorithm.playground.leetcode.problems.utils.linkedlist.Node
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.Node.node

/**
 * Input:
 *{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}*
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
class CopyListWithRandomPointerSpec extends Specification {

	@Unroll
	def "copyRandomList"() {

		given:

			def node = node(values, pointers)

		when:

			def copy = new S().copyRandomList(node)

		then:

			equalsButNotTheSame(copy, node)

		where:

			values | pointers
			[1, 2] | [1, 1]

	}

	private static boolean equalsButNotTheSame(Node a, Node b) {
		while (a != null && b != null) {
			if (a.val != b.val || a.random.val != b.random.val || a == b) {
				return false
			}
			a = a.next
			b = b.next
		}
		return a == null && b == null
	}

}