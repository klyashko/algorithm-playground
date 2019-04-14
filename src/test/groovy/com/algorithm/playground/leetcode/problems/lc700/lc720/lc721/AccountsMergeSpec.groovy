package com.algorithm.playground.leetcode.problems.lc700.lc720.lc721

import com.algorithm.playground.leetcode.problems.lc700.lc720.lc721.AccountsMerge.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class AccountsMergeSpec extends Specification {

	@Unroll
	def "accountsMerge"() {

		expect:

			new S().accountsMerge(accounts) as Set == output as Set

		where:

			accounts                    || output
			[["John", "johnsmith@mail.com", "john00@mail.com"],
			 ["John", "johnnybravo@mail.com"],
			 ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
			 ["Mary", "mary@mail.com"]] || [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
											["John", "johnnybravo@mail.com"],
											["Mary", "mary@mail.com"]]

	}

}
