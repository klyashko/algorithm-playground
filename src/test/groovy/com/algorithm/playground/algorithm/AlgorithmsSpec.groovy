package com.algorithm.playground.algorithm

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextList
import static com.algorithm.playground.algorithm.Algorithms.maxSumSubArray

class AlgorithmsSpec extends Specification {

	@Repeat(10)
	def "maxSumSubArray"() {

		given:

			def list = nextList(nextInt(50) + 1, { nextInt(-100, 100) })

		expect:

			sumSubArray(list) == maxSumSubArray(list as int[])

	}

	@SuppressWarnings("GroovyVariableNotAssigned")
	private static int sumSubArray(List<Integer> values) {
		int[] col = new int[values.size()]
		int max = Integer.MIN_VALUE
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j <= i; j++) {
				col[j] += values[i]
				max = Math.max(max, col[j])
			}
		}
		return max
	}

}