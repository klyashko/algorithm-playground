package com.algorithm.playground.algorithm

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextList

class CoordinateCompressionBuilderSpec extends Specification {

	@Repeat(10)
	def "build_collection"() {

		given:

			def ccb = new CoordinateCompressionBuilder()
			def values = nextList(nextInt(2, 50), { nextInt(0, 100) })
			ccb.addAll(values)

		when:

			def map = ccb.build()

		then:

			map
			map.size() == values.toSet().size()
			values.unique().sort().eachWithIndex { int entry, int idx -> assert map[entry] == idx }

	}

	@Repeat(10)
	def "build_array"() {

		given:

			def ccb = new CoordinateCompressionBuilder()
			def values = nextList(nextInt(2, 50), { nextInt(0, 100) }) as int[]
			ccb.addAll(values)

		when:

			def map = ccb.build()

		then:

			map
			map.size() == values.toSet().size()
			values.toSet().sort().eachWithIndex { int entry, int idx -> assert map[entry] == idx }

	}

	@Repeat(10)
	def "build_vararg"() {

		given:

			def ccb = new CoordinateCompressionBuilder()
			def values = nextList(nextInt(2, 50), { nextInt(0, 100) }) as Integer[]
			ccb.addAll(values)

		when:

			def map = ccb.build()

		then:

			map
			map.size() == values.toUnique().size()
			values.toUnique().sort().eachWithIndex { int entry, int idx -> assert map[entry] == idx }

	}

	@Repeat(10)
	def "build_add"() {

		given:

			def ccb = new CoordinateCompressionBuilder()
			def values = nextList(nextInt(2, 50), { nextInt(0, 100) })
			values.each { ccb.add(it) }

		when:

			def map = ccb.build()

		then:

			map
			map.size() == values.toSet().size()
			values.unique().sort().eachWithIndex { int entry, int idx -> assert map[entry] == idx }

	}

}