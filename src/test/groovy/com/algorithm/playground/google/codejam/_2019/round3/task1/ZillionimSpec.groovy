package com.algorithm.playground.google.codejam._2019.round3.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round3.task1.Solution.main
import static com.algorithm.playground.google.utils.LocalInteractiveTestRunner.run

class ZillionimSpec extends Specification {

	@Unroll
	def "Zillionim"() {

		given:

			run({ main() }, "src/test/resources/google/codejam/_2019/Zillionim/", arg)

		where:

			arg << ["0", "1", "2"]

	}

}