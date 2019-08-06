package com.algorithm.playground.leetcode.problems.lc200.lc230.lc234

import com.algorithm.playground.leetcode.problems.lc200.lc230.lc234.PalindromeLinkedList.Solution as S
import com.algorithm.playground.leetcode.problems.lc200.lc230.lc234.PalindromeLinkedList.SolutionWithStack as SWS
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

/**
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
class PalindromeLinkedListSpec extends Specification {

	@Unroll
	def "isPalindrome"() {

		expect:

			new S().isPalindrome(node(list)) == out

		where:

			list         || out
			[1, 2]       || false
			[1, 2, 2, 1] || true

	}

	@Unroll
	def "isPalindrome with stack"() {

		expect:

			new SWS().isPalindrome(node(list)) == out

		where:

			list         || out
			[1, 2]       || false
			[1, 2, 2, 1] || true

	}

}