package com.algorithm.playground.google.kickstart._2019.e.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.e.task2.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class CodeEatSwitcherSpec extends Specification {

	@Unroll
	def "Code-Eat Switcher"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""4 2
						3 8
						6 10
						0 18
						3 13
						10 0
						7 3""", "YYNY"],
					["""1 2
						4 4
						4 4
						0 0""", "Y"]
			)

	}

}
