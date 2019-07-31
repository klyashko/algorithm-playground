package com.algorithm.playground.google.kickstart._2019.d.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.d.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class XorWhatSpec extends Specification {

	@Unroll
	def "X or What?"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""4 3
                        10 21 3 7
                        1 13
                        0 32
                        2 22""", "4 3 4"],
					["""5 1
                        14 1 15 20 26
                        4 26""", "4"]
			)

	}

}