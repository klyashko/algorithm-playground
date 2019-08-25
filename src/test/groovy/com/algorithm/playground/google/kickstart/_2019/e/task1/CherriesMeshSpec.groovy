package com.algorithm.playground.google.kickstart._2019.e.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.e.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class CherriesMeshSpec extends Specification {

	@Unroll
	def "Cherries Mesh"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""2 1
						1 2""", "1"],
					["""3 1
						2 3""", "3"]
			)

	}

}
