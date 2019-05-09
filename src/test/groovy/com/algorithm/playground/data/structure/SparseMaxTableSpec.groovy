package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification
import spock.lang.Unroll

class SparseMaxTableSpec extends Specification {

	private static final Random RND = new Random()

	@Repeat(10)
	def "sparseMaxTable_getMaxIdx"() {
		given:
			def nQueries = RND.nextInt(20)
			def list = nextList(RND.nextInt(50) + 1, 75)

			def queries = (0..nQueries).collectEntries {
				def (lo, hi) = nextQueryInterval(list.size())
				return [([lo, hi]): list[lo..hi].indexOf(list[lo..hi].max()) + lo]
			}

			def st = new SparseMaxTable(list as int[])

		expect:

			queries.each {
				//noinspection GroovyAssignabilityCheck
				assert it.value == st.getMaxIdx(*it.key)
			}

	}

	@Repeat(10)
	def "sparseMaxTable_getMaxVal"() {
		given:
			def nQueries = RND.nextInt(20)
			def list = nextList(RND.nextInt(50) + 1, 75)

			def queries = (0..nQueries).collectEntries {
				def (lo, hi) = nextQueryInterval(list.size())
				return [([lo, hi]): list[lo..hi].max()]
			}

			def st = new SparseMaxTable(list as int[])

		expect:

			queries.each {
				//noinspection GroovyAssignabilityCheck
				assert it.value == st.getMaxVal(*it.key)
			}

	}

	@Unroll
	def "sparseMaxTable_getMaxIdx_lower_bound"() {
		given:
			def nQueries = RND.nextInt(20)
			def val = RND.nextInt(10)
			def list = (0..n).collect { val }

			def queries = (0..nQueries).collectEntries {
				def (lo, hi) = nextQueryInterval(list.size())
				return [([lo, hi]): lo]
			}

			def st = new SparseMaxTable(list as int[])

		expect:

			queries.each {
				//noinspection GroovyAssignabilityCheck
				assert it.value == st.getMaxIdx(*it.key)
			}

		where:

			n << [2, 3, 5, 7, 10]

	}

	private static List<Integer> nextList(int size, int bound) {
		return (0..size).collect { RND.nextInt(bound) }
	}

	private static int[] nextQueryInterval(int bound) {
		def lo = RND.nextInt(bound)
		def hi = RND.nextInt(bound - lo) + lo
		return [lo, hi]
	}

}