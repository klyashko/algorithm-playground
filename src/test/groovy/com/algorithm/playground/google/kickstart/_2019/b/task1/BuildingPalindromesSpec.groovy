package com.algorithm.playground.google.kickstart._2019.b.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.b.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class BuildingPalindromesSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ main() },
					["""7 5
						ABAACCA
						3 6
						4 4
						2 5
						6 7
						3 7""", "3"],
					["""7 1
						ABAACCA
						2 5""", "0"],
					["""3 5
						XYZ
						1 3
						1 3
						1 3
						1 3
						1 3""", "0"]
			)
	}

}
