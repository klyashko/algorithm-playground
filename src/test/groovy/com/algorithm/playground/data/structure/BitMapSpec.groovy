package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

class BitMapSpec extends Specification {

	private static final Random RND = new Random()

	@Repeat(10)
	def "bitMap"() {

		given:

			def bm = new BitMap()
			def rnd = new Random()
			def values = []
			def indexes = []
			30.times {
				indexes << rnd.nextInt(100)
				values << rnd.nextBoolean()
			}

			def lastStates = [indexes, values].transpose().collectEntries { idx, val -> [(idx): val] }

		when:

			[indexes, values].transpose().each { int idx, boolean val -> bm.set(idx, val) }

		then:

			!lastStates.findAll { bm.get(it.key as int) != it.value }

	}

	@Repeat(10)
	def "bitMap_intersection"() {

		given:

			def bound = 20
			def left = nextBitMap(bound, 30)
			def right = nextBitMap(bound, 40)
			def values = (0..bound).collect { left.get(it) && right.get(it) }

		when:

			def bm = left.intersection(right)

		then:

			!values.withIndex().findAll {
				boolean val, int idx -> bm.get(idx) != val
			}

	}

	@Repeat(10)
	def "bitMap_union"() {

		given:

			def bound = 2000
			def left = nextBitMap(bound, 30)
			def right = nextBitMap(bound, 40)
			def values = (0..bound).collect { left.get(it) || right.get(it) }

		when:

			def bm = left.union(right)

		then:

			!values.withIndex().findAll {
				boolean val, int idx -> bm.get(idx) != val
			}

	}

	@Repeat(10)
	def "bitMap_difference"() {

		given:

			def bound = 1000
			def left = nextBitMap(bound, 30)
			def right = nextBitMap(bound, 40)
			def values = (0..bound).collect { left.get(it) ^ right.get(it) }

		when:

			def bm = left.difference(right)

		then:

			!values.withIndex().findAll {
				boolean val, int idx -> bm.get(idx) != val
			}

	}

	private static nextBitMap(int bound, int updates) {
		return new BitMap().with {
			updates.times { set(RND.nextInt(bound), RND.nextBoolean()) }
			return it
		}
	}

}