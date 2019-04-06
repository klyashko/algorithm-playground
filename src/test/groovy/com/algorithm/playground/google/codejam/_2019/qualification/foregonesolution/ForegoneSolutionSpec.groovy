package com.algorithm.playground.google.codejam._2019.qualification.foregonesolution

import spock.lang.Specification
import spock.lang.Unroll

class ForegoneSolutionSpec extends Specification {

	@Unroll
	def "solve"() {

		when:

			def ans = Solution.solve(n)
			println(ans)

		then:

			!ans.toString().contains("4")

		where:

			n    || out
			4    || [2, 2]
			940  || [852, 88]
			4444 || [667, 3777]

	}

}
