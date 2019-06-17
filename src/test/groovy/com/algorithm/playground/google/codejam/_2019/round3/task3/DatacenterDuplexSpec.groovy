package com.algorithm.playground.google.codejam._2019.round3.task3

import spock.lang.Specification

import static Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec


class DatacenterDuplexSpec extends Specification {

	def "Datacenter Duplex"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ -> main() },
					["""2 2
                        AB
                        BA""", "IMPOSSIBLE"],
					["""2 3
                        AAB
                        ABB""", "POSSIBLE"],
					["""3 4
                        BBAA
                        BABA
                        BBAA""", "POSSIBLE"]
			)

	}

}