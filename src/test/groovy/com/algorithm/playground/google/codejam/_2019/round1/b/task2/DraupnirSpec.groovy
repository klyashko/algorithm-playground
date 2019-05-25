package com.algorithm.playground.google.codejam._2019.round1.b.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round1.b.task2.Solution.main
import static com.algorithm.playground.google.utils.LocalInteractiveTestRunner.run

class DraupnirSpec extends Specification {

	@Unroll
	def "draupnir"() {

		given:

			run({ main() }, "src/test/resources/google/Draupnir/", arg)

		where:

			arg || _
			"0" || _
			"1" || _

	}

}