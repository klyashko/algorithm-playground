package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import com.algorithm.playground.data.structure.IntITuple2 as IIT
import spock.lang.Specification

import java.util.Map.Entry

import static com.algorithm.playground.TestUtils.*

class SegmentMinLazyTreeSpec extends Specification {

	@Repeat(10)
	def "segmentMinLazyTree_query"() {
		given:
			def nQueries = nextInt(20)
			def list = nextList(nextInt(50) + 1, 75)

			def queries = (0..nQueries).collectEntries {
				def (lo, hi) = nextQueryInterval(list.size())
				return [([lo, hi]): list[lo..hi].min()]
			}

			def tree = new SegmentMinLazyTree(list as int[])

		expect:

			queries.each {
				//noinspection GroovyAssignabilityCheck
				assert it.value == tree.query(*it.key)
			}

	}

	@Repeat(10)
	def "segmentMinLazyTree_update_before_query"() {
		given:

			def nQueries = nextInt(20)
			def nUpdates = nextInt(20)
			def list = nextList(nextInt(50) + 1, 75)

			def updates = (0..nUpdates).collect { [nextInt(list.size()), nextInt(75)] }
			def tree = new SegmentMinLazyTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				if (it < updates.size()) {
					list[updates[it][0]] = updates[it][1]
				}
				return [(new IIT(lo, hi)): list[lo..hi].min()]
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
	def "segmentMinLazyTree_increment_before_query"() {
		given:

			def nQueries = nextInt(20)
			def nIncrements = nextInt(20)
			def list = nextList(nextInt(50) + 1, 75)

			def intervals = (0..nIncrements).collect { nextQueryInterval(list.size()) }
			def updates = (0..nIncrements).collect { nextInt(-10, 10) }

			def tree = new SegmentMinLazyTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				if (it < updates.size()) {
					def interval = intervals[it]
					for (int i = interval[0]; i <= interval[1]; i++) {
						list[i] += updates[it]
					}
				}
				return [(new IIT(lo, hi)): list[lo..hi].min()]
			}

		expect:

			//noinspection GroovyAssignabilityCheck
			queries.eachWithIndex { Entry<IIT, Integer> entry, int idx ->
				if (idx < updates.size()) {
					def interval = intervals[idx]
					def val = updates[idx]
					tree.increment(interval[0], interval[1], val)
				}
				int lo = entry.key._1()
				int hi = entry.key._2()
				assert entry.value == tree.query(lo, hi)
			}

	}

}