package com.algorithm.playground.graph

import com.algorithm.playground.graph.AllSimpleCyclesInDirectedGraphJohnsonAlgorithm as ASC
import spock.lang.Specification

class AllSimpleCyclesInDirectedGraphJohnsonAlgorithmSpec extends Specification {

	def "getCycles"() {

		given:

			def graph = [
					1: [2, 5, 8],
					2: [3, 7, 9],
					3: [1, 2, 6, 4],
					4: [5],
					5: [2],
					6: [4],
					7: [7],
					8: [9],
					9: [8]
			]
			def asc = new ASC<Integer>()

		when:

			def cycles = asc.getCycles(graph) as Set
			cycles.each { println(it) }

		then:

			cycles == [
					[1, 2, 3, 1],
					[1, 5, 2, 3, 1],
					[1, 5, 2, 3, 1],
					[2, 3, 2],
					[2, 3, 4, 5, 2],
					[2, 3, 6, 4, 5, 2],
					[8, 9, 8],
					[7, 7]
			] as Set

	}

}
