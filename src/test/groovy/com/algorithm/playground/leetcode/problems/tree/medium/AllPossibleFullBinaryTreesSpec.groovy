package com.algorithm.playground.leetcode.problems.tree.medium

import com.algorithm.playground.leetcode.problems.tree.medium.AllPossibleFullBinaryTrees.MemoSolution as MS
import com.algorithm.playground.leetcode.problems.tree.medium.AllPossibleFullBinaryTrees.MemoSolution_ as MS_
import com.algorithm.playground.leetcode.problems.tree.medium.AllPossibleFullBinaryTrees.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class AllPossibleFullBinaryTreesSpec extends Specification {

	@Unroll
	def "allPossibleFBT"() {

		given:

			def l = output.collect { node(it) }

		when:

			def r = new S().allPossibleFBT(n)

		then:

			r
			r.size() == l.size()
			r == l

		where:

			n || output
			3 || [[0, 0, 0]]
			5 || [[0, 0, 0, null, null, 0, 0], [0, 0, 0, 0, 0, null, null]]

	}

	@Unroll
	def "allPossibleFBT_with_memo"() {

		given:

			def l = output.collect { node(it) }

		when:

			def r = new MS().allPossibleFBT(n)

		then:

			r
			r.size() == l.size()
			r == l

		where:

			n || output
			3 || [[0, 0, 0]]
			5 || [[0, 0, 0, null, null, 0, 0], [0, 0, 0, 0, 0, null, null]]

	}

	@Unroll
	def "allPossibleFBT_with_memo_old_school_way"() {

		given:

			def l = output.collect { node(it) }

		when:

			def r = new MS_().allPossibleFBT(n)

		then:

			r
			r.size() == l.size()
			r == l

		where:

			n || output
			3 || [[0, 0, 0]]
			5 || [[0, 0, 0, null, null, 0, 0], [0, 0, 0, 0, 0, null, null]]

	}

}
