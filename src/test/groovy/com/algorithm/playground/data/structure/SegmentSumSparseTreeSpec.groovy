package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import com.algorithm.playground.data.structure.IntITuple2 as IIT
import spock.lang.Specification

import java.util.Map.Entry

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextQueryInterval

class SegmentSumSparseTreeSpec extends Specification {

	@Repeat(10)
	def "segmentMaxTable_update_before_query"() {
		given:

			def nQueries = nextInt(20)
			def nUpdates = nextInt(20)
			def list = [0] * (nextInt(50) + 1)

			def updates = (0..nUpdates).collect { [nextInt(list.size()), nextInt(-10, 10)] }

			def tree = new SegmentSumSparseTree(list.size())

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				if (it < updates.size()) {
					list[updates[it][0]] = updates[it][1]
				}
				return [(new IIT(lo, hi)): list[lo..hi].sum()]
			}

		expect:

			//noinspection GroovyAssignabilityCheck
			queries.eachWithIndex { Entry<IIT, Integer> entry, int idx ->
				if (idx < updates.size()) {
					tree.update(updates[idx][0], updates[idx][1])
				}
				int lo = entry.key._1()
				int hi = entry.key._2()
				assert entry.value == tree.query(lo, hi)
			}

	}

	@Repeat(10)
	def "segmentMaxTable_from_array_query"() {
		given:

			def nQueries = nextInt(20)
			def nUpdates = nextInt(20)
			def list = [0] * (nextInt(50) + 1)

			nUpdates.times {
				list[nextInt(list.size())] = nextInt(-10, 10)
			}

			def tree = new SegmentSumSparseTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				return [(new IIT(lo, hi)): list[lo..hi].sum()]
			}

		expect:

			//noinspection GroovyAssignabilityCheck
			queries.eachWithIndex { Entry<IIT, Integer> entry, int idx ->
				int lo = entry.key._1()
				int hi = entry.key._2()
				assert entry.value == tree.query(lo, hi)
			}

	}

	@Repeat(10)
	def "segmentMaxTable_from_array_update_before_query"() {
		given:

			def nQueries = nextInt(20)
			def nUpdates = nextInt(20)
			def list = [0] * (nextInt(50) + 1)

			def updates = (0..nUpdates).collect { [nextInt(list.size()), nextInt(-10, 10)] }

			def tree = new SegmentSumSparseTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				if (it < updates.size()) {
					list[updates[it][0]] = updates[it][1]
				}
				return [(new IIT(lo, hi)): list[lo..hi].sum()]
			}

		expect:

			//noinspection GroovyAssignabilityCheck
			queries.eachWithIndex { Entry<IIT, Integer> entry, int idx ->
				if (idx < updates.size()) {
					tree.update(updates[idx][0], updates[idx][1])
				}
				int lo = entry.key._1()
				int hi = entry.key._2()
				assert entry.value == tree.query(lo, hi)
			}

	}

}