package com.algorithm.playground.google.kickstart._2019.f.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.kickstart._2019.f.task1.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class FlatteningSpec extends Specification {

	@Unroll
	def "Flattening"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""8 2
						300 100 300 300 200 100 800 500""", "3"],
//					["""5 3
//						100 100 100 100 3""", "0"],
//					["""7 3
//						10 20 40 10 10 30 30""", "1"],
//					["""10 2
//						30 30 60 60 90 90 60 60 30 30""", "2"]
			)

	}

}
