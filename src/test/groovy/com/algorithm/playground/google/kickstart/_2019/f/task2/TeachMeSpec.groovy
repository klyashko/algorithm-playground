package com.algorithm.playground.google.kickstart._2019.f.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.f.task2.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class TeachMeSpec extends Specification {

	@Unroll
	def "Teach Me"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""4 100
						4 80 90 100 5
						1 90
						1 80
						3 80 90 100""", "7"],
					["""3 30
						4 10 11 12 13
						4 10 11 12 13
						5 25 26 27 28 29""", "4"]
			)

	}

}
