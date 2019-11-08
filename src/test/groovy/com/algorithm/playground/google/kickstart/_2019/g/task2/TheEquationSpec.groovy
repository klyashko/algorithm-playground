package com.algorithm.playground.google.kickstart._2019.g.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.g.task2.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class TheEquationSpec extends Specification {

	@Unroll
	def "The Equation"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""3 27
                        8 2 4""", "12"],
					["""4 45
                        30 0 4 11""", "14"],
					["""1 0
                        100""", "100"],
					["""6 2
                        5 5 1 5 1 0""", "-1"]
			)

	}

}