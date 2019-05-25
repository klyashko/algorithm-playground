package com.algorithm.playground.google.codejam._2019.round2.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round2.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class NewElementsPart1Spec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""3
                        1 1
                        1 2
                        2 1""", "2"],
					["""4
                        1 2
                        2 4
                        2 1
                        4 2""", "2"],
					["""3
                        1 2
                        1 3
                        2 3""", "1"]
			)

	}

}