package com.algorithm.playground.graph

import com.algorithm.playground.graph.StronglyConnectedComponentsKosarajuAlgorithm as SCC
import spock.lang.Specification

class StronglyConnectedComponentsKosarajuAlgorithmSpec extends Specification {

	def "getComponents"() {

		given:

			def graph = [
					A: ['B'],
					B: ['C', 'D'],
					C: ['A'],
					D: ['E'],
					E: ['F'],
					F: ['D'],
					G: ['F', 'H'],
					H: ['I'],
					I: ['J'],
					J: ['G', 'K'],
					K: []
			]

			def scc = new SCC<String>()

		when:

			def components = scc.getComponents(graph) as Set
			components.each { println(it) }

		then:

			components
			components == [
					['A', 'B', 'C'],
					['D', 'E', 'F'],
					['G', 'H', 'I', 'J'],
					['K']
			].collect { it.toSet() }.toSet()

	}

}
