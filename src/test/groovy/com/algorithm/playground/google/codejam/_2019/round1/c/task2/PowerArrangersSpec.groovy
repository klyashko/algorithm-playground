package com.algorithm.playground.google.codejam._2019.round1.c.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round1.c.task2.Solution.main
import static com.algorithm.playground.google.utils.LocalInteractiveTestRunner.run

class PowerArrangersSpec extends Specification {

	@Unroll
	def "solve"() {
		given:

			run({ main() }, "src/test/resources/google/codejam/_2019/PowerArrangers/", arg)

		where:

			arg || _
			"0" || _
			"1" || _
	}

}