package com.leetcode.problems.math.easy

import com.leetcode.problems.math.easy.AddDigits.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class AddDigitsSpec extends Specification {

	@Unroll
	def "addDigits"() {

		expect:

			new S().addDigits(n) == output

		where:

			n  || output
			38 || 2

	}

}
