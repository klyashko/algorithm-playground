package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.*

class KDTreeSpec extends Specification {

	@Repeat(10)
	def "KDTree#contains() success"() {

		given:

			def d = nextInt(2, 6)
			def tree = new KDTree(d)
			def points = (1..nextInt(2, 50)).collect {
				nextList(d, { nextSmallInt })
			}
			points.each { tree.insert(it as int[]) }

		expect:

			(1..nextInt(10, 50)).each {
				assert tree.contains(nextElement(points) as int[])
			}

	}

	@Repeat(10)
	def "KDTree#contains() failure"() {

		given:

			def d = nextInt(2, 6)
			def tree = new KDTree(d)
			def points = (1..nextInt(2, 50)).collect {
				nextList(d, { nextSmallInt })
			}.toSet()

			points.each { tree.insert(it as int[]) }

			def queries = (1..nextInt(2, 50)).collect { nextList(d, { nextSmallInt }, { !points.contains(it) }) }

		expect:

			queries.each {
				assert !tree.contains(it as int[])
			}

	}

}