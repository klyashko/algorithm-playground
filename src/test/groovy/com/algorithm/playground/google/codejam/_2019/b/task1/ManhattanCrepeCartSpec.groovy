package com.algorithm.playground.google.codejam._2019.b.task1

import com.algorithm.playground.google.utils.GoogleUtils
import spock.lang.Specification
import spock.lang.Unroll

class ManhattanCrepeCartSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << GoogleUtils.exec(
					{ -> Solution.main() },
					["""1 10
							5 5 N""", "0 6"],
					["""4 10
							2 4 N
							2 6 S
							1 5 E
							3 5 W""", "2 5"],
					["""8 10
							0 2 S
							0 3 N
							0 3 N
							0 4 N
							0 5 S
							0 5 S
							0 8 S
							1 5 W""", "0 4"],
					["""4 10
							0 1 N
							1 1 N
							0 5 S
							0 5 S""", "0 2"],
			)

	}

}
