package com.algorithm.playground.leetcode.problems.lc0.lc10.lc11

import com.algorithm.playground.leetcode.problems.lc0.lc10.lc11.ContainerWithMostWater.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
class ContainerWithMostWaterSpec extends Specification {

	@Unroll
	def "maxArea"() {

		expect:

			new S().maxArea(height as int[]) == out

		where:

			height                      || out
			[1, 8, 6, 2, 5, 4, 8, 3, 7] || 49

	}

}