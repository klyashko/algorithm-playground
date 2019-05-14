package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import com.algorithm.playground.data.structure.IntITuple2 as IIT
import spock.lang.Specification

import java.util.Map.Entry

import static com.algorithm.playground.TestUtils.*

class SegmentMaxTreeSpec extends Specification {

	@Repeat(10)
	def "segmentMaxTable_query"() {
		given:
			def nQueries = nextInt(20)
			def list = nextList(nextInt(50) + 1, 75)

			def queries = (0..nQueries).collectEntries {
				def (lo, hi) = nextQueryInterval(list.size())
				return [([lo, hi]): list[lo..hi].max()]
			}

			def tree = new SegmentMaxTree(list as int[])

		expect:

			queries.each {
				//noinspection GroovyAssignabilityCheck
				assert it.value == tree.query(*it.key)
			}

	}

	@Repeat(10)
	def "segmentMaxTable_update_before_query"() {
		given:

			def nQueries = nextInt(20)
			def nUpdates = nextInt(20)
			def list = nextList(nextInt(50) + 1, 75)

			def updates = (0..nUpdates).collect { [nextInt(list.size()), nextInt(75)] }
			def tree = new SegmentMaxTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				if (it < updates.size()) {
					list[updates[it][0]] = updates[it][1]
				}
				return [(new IIT(lo, hi)): list[lo..hi].max()]
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
	def "segmentMaxTable_remove_before_query"() {
		given:

			def list = nextList(nextInt(50) + 3, 75)
			def nRemoves = nextInt(list.size() - 3)
			def nQueries = nextInt(20)

			def removes = (0..nRemoves).collect { nextInt(list.size() - it) }

			def tree = new SegmentMaxTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				if (it < removes.size()) {
					list.remove(removes[it])
				}
				def (int lo, int hi) = nextQueryInterval(list.size())
				return [(new IIT(lo, hi)): list[lo..hi].max()]
			}

		expect:

			//noinspection GroovyAssignabilityCheck
			queries.eachWithIndex { Entry<IIT, Integer> entry, int idx ->
				if (idx < removes.size()) {
					tree.remove(removes[idx])
				}
				int lo = entry.key._1()
				int hi = entry.key._2()
				assert entry.value == tree.query(lo, hi)
			}

	}

	@Repeat(10)
	def "segmentMaxTable_insert_before_query"() {
		given:

			def nInserts = nextInt(40)
			def nQueries = nextInt(20)
			def list = nextList(nextInt(50) + 1, 75)

			def inserts = (0..nInserts).collect { nextInt(75) }
			def tree = new SegmentMaxTree(list as int[])

			def queries = (0..nQueries).collectEntries {
				def (int lo, int hi) = nextQueryInterval(list.size())
				if (it < inserts.size()) {
					list << inserts[it]
				}
				return [(new IIT(lo, hi)): list[lo..hi].max()]
			}

		expect:

			//noinspection GroovyAssignabilityCheck
			queries.eachWithIndex { Entry<IIT, Integer> entry, int idx ->
				if (idx < inserts.size()) {
					tree.add(inserts[idx])
				}
				int lo = entry.key._1()
				int hi = entry.key._2()
				assert entry.value == tree.query(lo, hi)
			}

	}

}