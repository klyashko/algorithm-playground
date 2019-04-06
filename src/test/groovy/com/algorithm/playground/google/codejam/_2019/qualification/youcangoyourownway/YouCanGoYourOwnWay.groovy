package com.algorithm.playground.google.codejam._2019.qualification.youcangoyourownway

import spock.lang.Specification
import spock.lang.Unroll

class YouCanGoYourOwnWay extends Specification {

	@Unroll
	def "solve"() {

		given:

			println Solution.solve(path)

		where:

			path       || _
			"SE"       || _
			"EESSSESE" || _
			"SEEEESSS" || _
			"SEES"     || _

	}

}
