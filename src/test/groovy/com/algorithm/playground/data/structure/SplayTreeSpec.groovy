package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.*
import static java.util.Collections.shuffle

class SplayTreeSpec extends Specification {

	@Repeat(10)
	def "SplayTree#contains() success"() {

		given:

			def tree = new SplayTree()
			def values = (1..nextInt(2, 50)).collect {
				def val = nextSmallInt
				tree.insert(val)
				return val
			}

		expect:

			(1..nextInt(10, 50)).each {
				assert tree.contains(nextElement(values))
			}

	}

	@Repeat(10)
	def "SplayTree#contains() failure"() {

		given:

			def tree = new SplayTree()
			def values = (1..nextInt(2, 50)).collect {
				def val = nextSmallInt
				tree.insert(val)
				return val
			}.toSet()
			def queries = nextList(nextInt(10, 50), { nextSmallInt }, { !(it in values) })

		expect:


			queries.each {
				assert !tree.contains(it)
			}

	}

	@Repeat(10)
	def "SplayTree#remove()"() {

		given:

			def tree = new SplayTree()
			def values = (1..nextInt(2, 50)).collect {
				def val = nextSmallInt
				tree.insert(val)
				return val
			}.unique()
			shuffle(values)

		expect:

			values.each {
				assert tree.contains(it)
				tree.remove(it)
				assert !tree.contains(it)
			}

	}

}