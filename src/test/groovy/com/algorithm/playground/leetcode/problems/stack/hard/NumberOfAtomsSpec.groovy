package com.algorithm.playground.leetcode.problems.stack.hard

import com.algorithm.playground.leetcode.problems.stack.hard.NumberOfAtoms.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NumberOfAtomsSpec extends Specification {

	@Unroll
	def "countOfAtoms"() {

		expect:

			new S().countOfAtoms(formula) == output

		where:

			formula         || output
			"H2O"           || "H2O"
			"Mg(OH)2"       || "H2MgO2"
			"K4(ON(SO3)2)2" || "K4N2O14S4"

	}

}
