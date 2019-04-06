package com.algorithm.playground.google.codejam._2019.qualification.foregonesolution

import spock.lang.Specification
import spock.lang.Unroll

class ForegoneSolutionSpec extends Specification {

	@Unroll
	def "solve"() {

		given:

			def ans = Solution.solve(n)
			println(ans)

		where:

			n      || out
			"4"    || _
			"940"  || _
			"4444" || _

	}

}
