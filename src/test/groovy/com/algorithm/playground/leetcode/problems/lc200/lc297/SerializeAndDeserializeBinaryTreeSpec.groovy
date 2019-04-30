package com.algorithm.playground.leetcode.problems.lc200.lc297

import com.algorithm.playground.leetcode.problems.lc200.lc297.SerializeAndDeserializeBinaryTree.Codec as C
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class SerializeAndDeserializeBinaryTreeSpec extends Specification {

	@Unroll
	def "serializeAndDeserialize"() {

		given:

			def node = node(n)
			def codec = new C()

		expect:

			codec.deserialize(codec.serialize(node)) == node

		where:

			n                              || _
			[1, 2, 3]                      || _
			[10, 9, 20, null, null, 15, 7] || _
			[]                             || _

	}

}
