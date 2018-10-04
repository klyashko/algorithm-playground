package com.leetcode.problems.queue.medium

import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.queue.medium.DesignCircularQueue.myCircularQueue as queue

class DesignCircularQueueSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "myCircularQueue"() {

		given:

			def q = queue(k)

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (arg) {
						assert q."$method"(arg) == result
					} else {
						assert q."$method"() == result
					}
			}

		where:

			k | methods                                                                                                        | args                                           || results
			3 | ["enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]                   | [[1], [2], [3], [4], [], [], [], [4], []]      || [true, true, true, false, 3, true, true, true, 4]
			6 | ["enQueue", "Rear", "Rear", "deQueue", "enQueue", "Rear", "deQueue", "Front", "deQueue", "deQueue", "deQueue"] | [[6], [], [], [], [5], [], [], [], [], [], []] || [true, 6, 6, true, true, 5, true, -1, false, false, false]

	}

}
