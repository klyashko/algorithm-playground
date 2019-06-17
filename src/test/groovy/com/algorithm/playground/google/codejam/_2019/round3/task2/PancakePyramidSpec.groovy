package com.algorithm.playground.google.codejam._2019.round3.task2

import spock.lang.Specification
import spock.lang.Unroll

import static Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class PancakePyramidSpec extends Specification {

	@Unroll
	def "Pancake Pyramid"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""3
                        2 1 2""", "1"],
					["""5
                        1 6 2 5 7""", "16"],
					["""4
                        1000000000 1 1 1000000000""", "999999991"]
			)

	}

}