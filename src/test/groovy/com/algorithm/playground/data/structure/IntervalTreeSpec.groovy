package com.algorithm.playground.data.structure

import com.algorithm.playground.data.structure.IntervalTree.Interval
import spock.lang.Specification

class IntervalTreeSpec extends Specification {

	def "simple"() {

		given:

			def tree = new IntervalTree([
					new Interval(1, 10),
					new Interval(2, 3),
					new Interval(4, 5),
					new Interval(5, 7),
					new Interval(7, 10)
			])
			println(tree)
			println(tree.query(4, 6))

	}

	def "insert"() {

		given:

			def tree = new IntervalTree([
					new Interval(1, 10),
					new Interval(2, 3),
					new Interval(4, 5),
					new Interval(5, 7),
					new Interval(7, 10)
			])
//			println(tree)
			println(tree.query(4, 6))

			tree.insert(new Interval(2, 5))
			println(tree.query(4, 6))

			tree.insert(new Interval(15, 20))
			println(tree.query(10, 16))

	}

}
