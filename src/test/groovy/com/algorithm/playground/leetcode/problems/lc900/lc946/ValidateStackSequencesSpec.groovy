package com.algorithm.playground.leetcode.problems.lc900.lc946

import com.algorithm.playground.leetcode.problems.lc900.lc946.ValidateStackSequences.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 */
class ValidateStackSequencesSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "validateStackSequences"() {

		expect:

			new S().validateStackSequences(pushed as int[], popped as int[]) == out

		where:

			pushed          | popped          || out
			[1, 2, 3, 4, 5] | [4, 5, 3, 2, 1] || true
			[1, 2, 3, 4, 5] | [4, 3, 5, 1, 2] || false


	}

}