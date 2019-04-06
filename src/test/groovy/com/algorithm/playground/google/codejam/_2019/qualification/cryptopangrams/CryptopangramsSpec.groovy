package com.algorithm.playground.google.codejam._2019.qualification.cryptopangrams

import spock.lang.Specification
import spock.lang.Unroll

class CryptopangramsSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(line, line.split(' ').size()) == out

		where:

			line                                                                                                                                                                               || out
			"15 15 21 77 143"                                                                                                                                                                  || "ABACDE"
			"15 15 35 77 143"                                                                                                                                                                  || "BABCDE"
			"15 15 21 21 33 143"                                                                                                                                                               || "ABACADE"
			"217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053"                                   || "CJQUIZKNOWBEVYOFDPFLUXALGORITHMS"
			"3292937 175597 18779 50429 375469 1651121 2102 3722 2376497 611683 489059 2328901 3150061 829981 421301 76409 38477 291931 730241 959821 1664197 3057407 4267589 4729181 5335543" || "SUBDERMATOGLYPHICFJKNQVWXZ"

	}

	def "main"() {
		given:
			def data = "2\n" +
					"103 31\n" +
					"217 1891 4819 2291 2987 3811 1739 2491 4717 445 65 1079 8383 5353 901 187 649 1003 697 3239 7663 291 123 779 1007 3551 1943 2117 1679 989 3053\n" +
					"10000 25\n" +
					"3292937 175597 18779 50429 375469 1651121 2102 3722 2376497 611683 489059 2328901 3150061 829981 421301 76409 38477 291931 730241 959821 1664197 3057407 4267589 4729181 5335543"
			def is = new ByteArrayInputStream(data.getBytes())
			System.in = is
			Solution.main()
	}

}
