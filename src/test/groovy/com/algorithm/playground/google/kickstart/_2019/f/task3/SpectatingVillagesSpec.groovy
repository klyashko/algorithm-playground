package com.algorithm.playground.google.kickstart._2019.f.task3

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.f.task3.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class SpectatingVillagesSpec extends Specification {

	@Unroll
	def "Spectating Villages"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""9
						-10 4 -10 8 20 30 -2 -3 7
						1 4
						2 4
						4 3
						9 4
						9 8
						7 5
						6 7
						7 9""", "67"],
					["""4
						-2 20 20 20
						1 2
						1 3
						1 4""", "58"],
					["""5
						-5 -10 8 -7 -2
						5 4
						4 3
						3 2
						2 1""", "0"]
			)

	}

}
