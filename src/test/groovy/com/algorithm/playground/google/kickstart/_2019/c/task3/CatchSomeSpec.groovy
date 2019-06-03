package com.algorithm.playground.google.kickstart._2019.c.task3

import spock.lang.Specification
import spock.lang.Unroll

import static Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class CatchSomeSpec extends Specification {

	@Unroll
	def "Catch Some"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""4 3
                        1 2 4 9
                        3 3 2 3""", "8"],
					["""4 3
                        1 2 3 4
                        1 8 1 8""", "6"],
					["""6 6
                        4 3 3 1 3 10000
                        1 2 8 9 5 7""", "10028"]
			)

	}

}