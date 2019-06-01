package com.algorithm.playground.google.codejam._2019.round2.task4

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round2.task4.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class ContransmutationSpec extends Specification {

	@Unroll
	def "Contransmutation"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""2
                        1 2
                        1 2
                        1 0""", "UNBOUNDED"],
					["""2
                        1 2
                        1 2
                        0 0""", "0"],
					["""4
                        2 4
                        3 4
                        2 4
                        2 3
                        10 10 10 10""", "10"]
			)

	}

}