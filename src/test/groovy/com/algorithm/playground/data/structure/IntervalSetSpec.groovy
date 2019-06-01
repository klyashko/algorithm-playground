package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import com.algorithm.playground.data.structure.IntervalSet.Interval
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextList
import static java.lang.Math.max
import static java.lang.Math.min

class IntervalSetSpec extends Specification {

	@Repeat(10)
	def "add_interval"() {

		given:

			def intervals = nextIntervals
			def s = new IntervalSet()
			intervals.each { s.add(it) }


		expect:

			s.toList() == sortAndMerge(intervals)

	}

	@Repeat(10)
	def "add"() {

		given:

			def intervals = nextIntervals
			def s = new IntervalSet()
			intervals.each { s.add(it.le, it.ri) }


		expect:

			s.toList() == sortAndMerge(intervals)

	}

	@Repeat(10)
	def "getOverlap"() {

		given:

			def intervals = nextIntervals
			def s = new IntervalSet()
			intervals.each { s.add(it) }
			def point = nextInt(1000)

		expect:

			s.getOverlap(point) == find(intervals, point)

	}

	@Repeat(10)
	def "getOverlaps"() {

		given:

			def intervals = nextIntervals
			def s = new IntervalSet()
			intervals.each { s.add(it) }
			def le = nextInt(1000)
			def len = nextInt(100)

		expect:

			s.getOverlaps(le, le + len) == findAll(intervals, new Interval(le, le + len))

	}

	@Repeat(10)
	def "getOverlaps_interval"() {

		given:

			def intervals = nextIntervals
			def s = new IntervalSet()
			intervals.each { s.add(it) }
			def le = nextInt(1000)
			def interval = new Interval(le, le + nextInt(100))

		expect:

			s.getOverlaps(interval) == findAll(intervals, interval)

	}

	private static List<Interval> getNextIntervals() {
		return nextList(nextInt(20), {
			int li = nextInt(1000)
			int len = nextInt(100)
			return new Interval(li, li + len)
		})
	}

	private static List<Interval> findAll(List<Interval> list, Interval interval) {
		return sortAndMerge(list).findAll() { it.isIntersect(interval) }
	}

	private static Interval find(List<Interval> list, int point) {
		return sortAndMerge(list).find { it.le <= point && it.ri >= point }
	}

	private static List<Interval> sortAndMerge(List<Interval> list) {
		List<Interval> result = []
		list.sort({ a, b -> a.le <=> b.le })
		Interval curr = null
		for (Interval i : list) {
			if (!curr) {
				curr = new Interval(i.le, i.ri)
			} else if (i.isIntersect(curr) || i.isIntersect(curr.le - 1) || i.isIntersect(curr.ri + 1)) {
				curr = new Interval(min(i.le, curr.le), max(i.ri, curr.ri))
			} else {
				result << curr
				curr = new Interval(i.le, i.ri)
			}
		}
		if (curr) {
			result << curr
		}
		return result
	}

}