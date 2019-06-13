package com.algorithm.playground.leetcode.problems.lc900.lc990

import com.algorithm.playground.leetcode.problems.lc900.lc990.SatisfiabilityOfEqualityEquations.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SatisfiabilityOfEqualityEquationsSpec extends Specification {

	@Unroll
	def "equationsPossible"() {

		expect:

			new S().equationsPossible(eq as String[]) == out

		where:

			eq                               || out
			["a==b", "b!=a"]                 || false
			["b==a", "a==b"]                 || true
			["a==b", "b==c", "a==c"]         || true
			["a==b", "b!=c", "c==a"]         || false
			["c==c", "b==d", "x!=z"]         || true
			["b==b", "b==e", "e==c", "d!=e"] || true
			["a==b", "e==c", "b==c", "a!=e"] || false

	}

}
