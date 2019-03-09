package com.algorithm.playground.leetcode.problems.stack.easy

import com.algorithm.playground.leetcode.problems.stack.easy.ImplementQueueUsingStacks.MyQueue as MQ
import spock.lang.Specification

class ImplementQueueUsingStacksSpec extends Specification {

	def "myQueue"() {

		given:

			def queue = new MQ()

			queue.push(1)
			queue.push(2)

		expect:

			queue.peek() == 1
			queue.pop() == 1
			!queue.empty()
			queue.pop() == 2
			queue.empty()

	}

}
