package com.algorithm.playground.leetcode.problems.lc300.lc330.lc332

import com.algorithm.playground.leetcode.problems.lc300.lc330.lc332.ReconstructItinerary.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReconstructItinerarySpec extends Specification {

	@Unroll
	def "findItinerary"() {

		expect:

			new S().findItinerary(tickets) == out

		where:

			tickets                                                                                                                                                          || out
			[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]                                                                                                 || ["JFK", "MUC", "LHR", "SFO", "SJC"]
			[["JFK", "SFO"], ["JFK", "ATL"], ["SFO", "ATL"], ["ATL", "JFK"], ["ATL", "SFO"]]                                                                                 || ["JFK", "ATL", "JFK", "SFO", "ATL", "SFO"]
			[["JFK", "KUL"], ["JFK", "NRT"], ["NRT", "JFK"]]                                                                                                                 || ["JFK", "NRT", "JFK", "KUL"]
			[["JFK", "AAA"], ["AAA", "JFK"], ["JFK", "BBB"], ["JFK", "CCC"], ["CCC", "JFK"]]                                                                                 || ["JFK", "AAA", "JFK", "CCC", "JFK", "BBB"]
			[["EZE", "AXA"], ["TIA", "ANU"], ["ANU", "JFK"], ["JFK", "ANU"], ["ANU", "EZE"], ["TIA", "ANU"], ["AXA", "TIA"], ["TIA", "JFK"], ["ANU", "TIA"], ["JFK", "TIA"]] || ["JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK"]

	}

}
