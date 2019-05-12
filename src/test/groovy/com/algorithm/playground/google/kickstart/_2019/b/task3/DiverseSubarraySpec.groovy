package com.algorithm.playground.google.kickstart._2019.b.task3

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.b.task3.Solution_.main as sample
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class DiverseSubarraySpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
//					{ main() },
					{ sample() },
					["""6 2
						1 1 4 1 4 4""", "4"],
//					["""8 1
//						1 2 500 3 4 500 6 7""", "6"],
//					["""10 1
//						100 200 8 8 8 8 8 300 400 100""", "4"],
//					["""12 2
//						40 50 1 1 1 60 70 2 2 2 80 90""", "6"]
			)
	}

}
