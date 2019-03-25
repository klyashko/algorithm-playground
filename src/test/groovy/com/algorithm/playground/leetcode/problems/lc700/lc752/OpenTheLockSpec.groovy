package com.algorithm.playground.leetcode.problems.lc700.lc752

import com.algorithm.playground.leetcode.problems.lc700.lc752.OpenTheLock
import spock.lang.Specification
import spock.lang.Unroll

class OpenTheLockSpec extends Specification {

	@Unroll
	def "openLock"() {

		expect:

			new OpenTheLock.Solution().openLock(deadends as String[], target) == output

		where:

			deadends                                                         | target || output
			["0201", "0101", "0102", "1212", "2002"]                         | "0202" || 6
			["8888"]                                                         | "0009" || 1
			["8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"] | "8888" || -1
			["0000"]                                                         | "8888" || -1

	}

}
