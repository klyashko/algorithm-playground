package com.algorithm.playground.leetcode.problems.random.medium

import spock.lang.Specification
import spock.lang.Unroll

import static RandomFlipMatrix.solution

class RandomFlipMatrixSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
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
