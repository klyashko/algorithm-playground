package com.algorithm.playground.google.kickstart._2019.d.task3

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.d.task3.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec


class FoodStallsSpec extends Specification {

	@Unroll
	def "Food Stalls"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""2 4
                        1 2 3 10
                        100 70 80 20""", "178"],
					["""1 5
                        150 300 301 400 700
                        8 35 26 5 2""", "62"],
					["""6 7
                        22 21 20 23 26 25 24
                        10 10 10 10 10 10 10""", "82"]
			)

	}

}