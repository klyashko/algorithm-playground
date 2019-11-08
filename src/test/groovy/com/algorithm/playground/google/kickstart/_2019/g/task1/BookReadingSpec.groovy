package com.algorithm.playground.google.kickstart._2019.g.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.g.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class BookReadingSpec extends Specification {

	@Unroll
	def "Book Reading"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""11 1 2
                        8
                        2 3""", "7"],
					["""11 11 11
                        1 2 3 4 5 6 7 8 9 10 11
                        1 2 3 4 5 6 7 8 9 10 11""", "0"],
					["""1000 6 1
                        4 8 15 16 23 42
                        1""", "994"]
			)

	}

}