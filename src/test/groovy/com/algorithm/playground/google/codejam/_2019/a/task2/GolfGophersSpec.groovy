package com.algorithm.playground.google.codejam._2019.a.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.utils.LocalInteractiveTestRunner.run

class GolfGophersSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			run({ -> Solution.main() }, "src/test/resources/google/GolfGophers/", arg)

		where:

			arg || _
			"0" || _
			"1" || _

	}

}
