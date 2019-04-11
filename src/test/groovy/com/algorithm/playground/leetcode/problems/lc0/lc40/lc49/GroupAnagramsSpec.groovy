package com.algorithm.playground.leetcode.problems.lc0.lc40.lc49

import com.algorithm.playground.leetcode.problems.lc0.lc40.lc49.GroupAnagrams.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class GroupAnagramsSpec extends Specification {

	@Unroll
	def "groupAnagrams"() {

		given:

			def vals = out.collect { it as Set }.toSet()

		expect:

			new S().groupAnagrams(strs as String[]).collect { it as Set } as Set == vals

		where:
			strs                                       || out
			["eat", "tea", "tan", "ate", "nat", "bat"] || [["ate", "eat", "tea"],
														   ["nat", "tan"],
														   ["bat"]]
			["eat", "tea", "ate"]                      || [["ate", "eat", "tea"]]

	}

}
