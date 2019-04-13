package com.algorithm.playground.google.codejam._2019.a.task3

import spock.lang.Specification
import spock.lang.Unroll

class AlienRhymeSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(words as String[]) == out

		where:

			words      || out
			['TARPOL',
			 'PROL']   || 2
			['TARPOR',
			 'PROL',
			 'TARPRO'] || 0
			['CODEJAM',
			 'JAM',
			 'HAM',
			 'NALAM',
			 'HUM',
			 'NOLOM']  || 6
			['PI',
			 'HI',
			 'WI',
			 'FI']     || 2

	}

}
