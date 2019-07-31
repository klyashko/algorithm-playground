package com.algorithm.playground.google.kickstart._2019.d.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.d.task2.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec


class LatestGuestsSpec extends Specification {

	@Unroll
	def "Latest Guests"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""5 3 2
                        5 C
                        2 A
                        1 A""", "2 2 1"],
					["""2 4 0
                        1 A
                        1 C
                        1 A
                        1 C""", "1 1 1 1"],
					["""3 2 10
                        3 C
                        2 A""", "2 2"],
					["""6 1 6
                        4 A""", "6"]
			)

	}

}