package com.algorithm.playground.google.kickstart._2019.c.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.c.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class WiggleWalkSpec extends Specification {

	@Unroll
	def "Wiggle Walk"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""5 3 6 2 3
                        EEWNS""", "3 2"],
					["""4 3 3 1 1
                        SESE""", "3 3"],
					["""11 5 8 3 4
                        NEESSWWNESE""", "3 7"]
			)

	}

}