package com.algorithm.playground.google.kickstart._2019.e.task3

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.e.task3.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class StreetCheckersSpec extends Specification {

	@Unroll
	def "Street Checkers"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""5 10""", "5"],
					["""102 102""", "1"]
			)

	}

}
