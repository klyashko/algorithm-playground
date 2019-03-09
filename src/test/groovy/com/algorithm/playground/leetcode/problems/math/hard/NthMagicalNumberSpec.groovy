package com.algorithm.playground.leetcode.problems.math.hard

import com.algorithm.playground.leetcode.problems.math.hard.NthMagicalNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NthMagicalNumberSpec extends Specification {

	@Unroll
	def "nthMagicalNumber"() {

		expect:

			new S().nthMagicalNumber(n, a, b) == output

		where:

			n          | a     | b     || output
			1          | 2     | 3     || 2
			7          | 5     | 8     || 24
			4          | 2     | 3     || 6
			8          | 2     | 11    || 14
			6          | 2     | 11    || 11
			5          | 2     | 4     || 10
			3          | 6     | 4     || 8
			3          | 4     | 6     || 8
			1000000000 | 40000 | 40000 || 999720007
			887859796  | 29911 | 37516 || 257511204
			136        | 556   | 584   || 38920
			10         | 10    | 8     || 50
			3          | 6     | 4     || 8
			885        | 389   | 256   || 136928
			875        | 885   | 240   || 167280

	}

}
