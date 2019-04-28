package com.algorithm.playground.google.codejam._2019.b.task2

import com.algorithm.playground.google.utils.GoogleUtils
import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << GoogleUtils.exec(
					{ -> Solution.main() },
					["2 2", "IMPOSSIBLE"],
					["2 5", "POSSIBLE"],
					["3 3", "IMPOSSIBLE"],
					["2 3", "IMPOSSIBLE"]
			)

	}

}
