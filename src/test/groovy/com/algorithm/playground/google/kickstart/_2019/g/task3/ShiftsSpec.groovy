package com.algorithm.playground.google.kickstart._2019.g.task3

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.g.task3.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class ShiftsSpec extends Specification {

	@Unroll
	def "Shifts"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""2 3
                        1 2
                        3 3""", "3"],
					["""2 5
                        2 2
                        10 30""", "0"],
					["""1 3
                        3
                        3""", "1"]
			)

	}

}