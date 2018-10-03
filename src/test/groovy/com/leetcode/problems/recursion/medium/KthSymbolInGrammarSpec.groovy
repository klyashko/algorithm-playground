package com.leetcode.problems.recursion.medium

import com.leetcode.problems.recursion.medium.KthSymbolInGrammar.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KthSymbolInGrammarSpec extends Specification {

	@Unroll
	def "kthGrammar"() {

		expect:

			new S().kthGrammar(N, K) == output

		where:

			N  | K         || output
			1  | 1         || 0
			2  | 1         || 0
			2  | 2         || 1
			4  | 5         || 1
			30 | 434991989 || 0

	}

}
