package com.algorithm.playground.leetcode.problems.lc500.lc510.lc519

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.lc500.lc510.lc519.RandomFlipMatrix.solution

class RandomFlipMatrixSpec extends Specification {

	@Unroll
	def "randomFlipMatrix"() {

		given:

			def s = solution(r, c)

		expect:

			methods.each { println("$it result ${s."$it"()}") }

		where:

			r | c | methods
			2 | 3 | ["flip", "flip", "flip", "flip"]
			1 | 2 | ["flip", "flip", "reset", "flip"]
			2 | 2 | ["flip", "flip", "flip", "flip"]
			1 | 2 | ["flip", "flip", "reset", "flip"]

	}

}
