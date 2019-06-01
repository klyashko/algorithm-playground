package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextList

class IntListSpec extends Specification {

	@Repeat(10)
	def "create"() {

		given:

			def data = nextList(nextInt(100), 100)
			def list = new IntList(data as int[])

		expect:

			equals(list, data)

	}

	@Repeat(10)
	def "add"() {

		given:

			def data = nextList(nextInt(100), 100)
			def list = new IntList()
			data.each { list.add(it) }

		expect:

			equals(list, data)

	}

	@Repeat(10)
	def "set"() {

		given:

			def data = nextList(nextInt(100), 100)
			def list = new IntList()
			data.each { list.add(it) }

			def nUpdate = nextInt(data.size())
			def updates = (0..nUpdate).collectEntries { [(nextInt(data.size())): nextInt(100)] }

		expect:

			//noinspection GroovyAssignabilityCheck
			!updates.find { int idx, int val ->
				list.set(idx, val)
				data.set(idx, val)
				return !equals(list, data)
			}

	}

	@Repeat(10)
	def "remove"() {

		given:

			def data = nextList(nextInt(100), 100)
			def list = new IntList()
			data.each { list.add(it) }

			def nRemoves = nextInt(data.size())
			def removes = (0..nRemoves).collect { nextInt(data.size() - it) }

		expect:

			!removes.find { int idx ->
				list.remove(idx)
				data.remove(idx)
				return !equals(list, data)
			}

	}

	@Repeat(10)
	def "ArrayIndexOutOfBoundsException"() {

		given:

			def list = new IntList(nextList(nextInt(100), 100) as int[])

		when:

			list.get(nextInt(list.size(), list.size() << 1))

		then:

			thrown(ArrayIndexOutOfBoundsException)

	}

	private static boolean equals(IntList data, List<Integer> list) {
		return !list.withIndex().find { int entry, int idx -> data.get(idx) != entry }
	}

}