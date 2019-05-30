package com.algorithm.playground.leetcode.problems.lc300.lc300.lc304


import spock.lang.Specification

class RangeSumQuery2DImmutableSpec extends Specification {

	def "NumMatrix"() {

		given:

			def nm = new NumMatrix(martix as int[][])

		expect:

			[args, results].transpose().each { arg, result ->
				println("sumRegion with ($arg) expect $result")
				//noinspection GroovyAssignabilityCheck
				assert nm.sumRegion(arg) == result
			}

		where:

			martix            | args                                       || results
			[[3, 0, 1, 4, 2],
			 [5, 6, 3, 2, 1],
			 [1, 2, 0, 1, 5],
			 [4, 1, 0, 1, 7],
			 [1, 0, 3, 0, 5]] | [[2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]] || [8, 11, 12]

	}

}
