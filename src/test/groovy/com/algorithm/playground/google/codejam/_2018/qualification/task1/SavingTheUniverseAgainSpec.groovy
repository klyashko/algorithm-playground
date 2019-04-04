package com.algorithm.playground.google.codejam._2018.qualification.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2018.qualification.task1.Solution.main


class SavingTheUniverseAgainSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(line, n) == out

		where:

			line     | n || out
			"CS"     | 1 || 1
			"CS"     | 2 || 0
			"SS"     | 1 || -1
			"SCCSSC" | 6 || 2
			"CC"     | 2 || 0
			"CSCSS"  | 3 || 5

	}

	def "full"() {
		given:

			def data = "6\n" +
					"1 CS\n" +
					"2 CS\n" +
					"1 SS\n" +
					"6 SCCSSC\n" +
					"2 CC\n" +
					"3 CSCSS"
			System.in = new ByteArrayInputStream(data.getBytes())
			main()
	}

}
