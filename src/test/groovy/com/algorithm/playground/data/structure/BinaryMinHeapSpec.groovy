package com.algorithm.playground.data.structure

import spock.lang.Specification

/**
 * An implementation od Dijkstra algorithm
 */
class BinaryMinHeapSpec extends Specification {

	def "dijkstra"() {

		given:

			def graph = [
					A: [B: 5, D: 9, E: 2],
					B: [A: 5, C: 3],
					C: [B: 2, D: 3],
					D: [C: 3, F: 2],
					E: [A: 2, F: 3],
					F: [E: 3, D: 2]
			]
			def heap = new BinaryMinHeap<String, Integer>()
			def start = 'A'
			def end = 'D'
			def weights = [:]
			def parents = [(start): '']

			graph.each { heap.put(it.key, it.key == start ? 0 : Integer.MAX_VALUE) }

		when:

			while (!heap.isEmpty()) {
				def curr = heap.pollMin()
				weights[curr._1()] = curr._2()
				graph[curr._1()].each {
					if (heap.contains(it.key)) {
						def weight = heap.get(it.key)
						if (weight > curr._2() + it.value) {
							heap.put(it.key, curr._2() + it.value)
							parents[it.key] = curr._1()
						}
					}
				}
			}

			def path = []
			def curr = end
			while (curr) {
				path << curr
				curr = parents[curr]
			}

			println(weights)
			println(parents)

		then:

			weights[end] == 7
			path.reverse() == ['A', 'E', 'F', 'D']

	}

}
