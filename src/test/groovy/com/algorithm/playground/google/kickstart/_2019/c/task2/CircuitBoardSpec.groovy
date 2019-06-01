package com.algorithm.playground.google.kickstart._2019.c.task2

import spock.lang.Specification
import spock.lang.Unroll

import static Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec


class CircuitBoardSpec extends Specification {

	@Unroll
	def "Circuit Board"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""1 4 0
                        3 1 3 3""", "2"],
					["""2 3 0
                        4 4 5
                        7 6 6""", "2"],
					["""4 5 0
                        2 2 4 4 20
                        8 3 3 3 12
                        6 6 3 3 3
                        1 6 8 6 4""", "6"]
			)

	}

}