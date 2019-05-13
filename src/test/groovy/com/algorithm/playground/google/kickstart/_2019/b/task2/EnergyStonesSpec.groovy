package com.algorithm.playground.google.kickstart._2019.b.task2

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.b.task2.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class EnergyStonesSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ main() },
					["""4
                        20 10 1
                        5 30 5
                        100 30 1
                        5 80 60""", "105"],
					["""3
                        10 4 1000
                        10 3 1000
                        10 8 1000""", "8"],
					["""4
                        10 4 1000
                        10 3 1000
                        10 8 1000
                        10 8 0""", "16"],
					["""5
                        10 8 0
                        10 4 1000
                        10 3 1000
                        10 8 1000
                        10 8 0""", "24"],
					["""3
                        1 16 6
                        1 3 10
                        1 8 10""", "18"],
					["""2
                        12 300 50
                        5 200 0""", "500"]
			)

	}

}