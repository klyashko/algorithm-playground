package com.algorithm.playground.google.codejam._2019.a.task1

import spock.lang.Specification
import spock.lang.Unroll

class PylonsSpec extends Specification {

	@Unroll
	def "solve"() {

		given:

			def path = Solution.solve(rows, cols)
			validate(path)
			println(path)

		where:

			rows | cols
			2    | 2
			2    | 5
			3    | 3
			2    | 3

	}

	def validate(LinkedList<int[]> path) {
		if (path) {
			int[] prev = null
			path.each {
				if (prev) {
					assert prev[0] != it[0] && prev[1] != it[1] && prev.sum() != it.sum() && prev[0] - prev[1] != it[0] - it[1]
				}
				prev = it
			}
		}
	}

}
