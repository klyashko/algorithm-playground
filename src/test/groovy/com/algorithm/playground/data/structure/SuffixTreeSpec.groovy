package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextString

class SuffixTreeSpec extends Specification {

	@Repeat(10)
	def "longestMostRepeatedSubstring"() {

		given:

			def text = nextString(nextInt(20, 50))
			def tree = new SuffixTree(text)

		expect:

			findLongestMostRepeatedSubstring(text) == tree.longestMostRepeatedSubstring()

	}

	@Repeat(10)
	def "longestRepeatedSubstring"() {

		given:

			def text = nextString(nextInt(20, 30))
			def tree = new SuffixTree(text)

		expect:

			findLongestRepeatedSubstring(text) == tree.longestRepeatedSubstring()

	}

	@Repeat(10)
	def "contains_success"() {

		given:

			def text = nextString(nextInt(5, 50))
			def tree = new SuffixTree(text)

		expect:

			for (int i = 0; i < text.length(); i++) {
				for (int j = i + 1; j < text.length(); j++) {
					assert tree.contains(text.substring(i, j))
				}
			}

	}

	@Repeat(10)
	def "contains_failure"() {

		given:

			def text = nextString(nextInt(5, 50))
			def p = nextString(nextInt(5, 10))
			def tree = new SuffixTree(text.replaceAll(p, ""))

		expect:

			!tree.contains(p)


	}

	private static String findLongestRepeatedSubstring(String text) {
		def queue = new PriorityQueue<String>()
		for (int i = text.length() - 1; i > 0; i--) {
			for (int j = 0; j < text.length() - i; j++) {
				def curr = text.substring(j, j + i)
				def count = 0, idx = j
				while ((idx = text.indexOf(curr, idx) + 1) != 0) {
					if (++count == 2) {
						queue.offer(curr)
						break
					}
				}
			}
			if (queue) {
				return queue.peek()
			}
		}
		return ""
	}

	private static String findLongestMostRepeatedSubstring(String text) {
		def queue = new PriorityQueue<Tuple2<String, Integer>>({ a, b -> b._2() <=> a._2() ?: b._1().length() <=> a._1().length() ?: a._1() <=> b._1() })
		for (int i = text.length() - 1; i > 0; i--) {
			for (int j = 0; j < text.length() - i; j++) {
				def curr = text.substring(j, j + i)
				def count = 0, idx = j
				while ((idx = text.indexOf(curr, idx) + 1) != 0) {
					count++
				}
				queue.offer(new Tuple2<String, Integer>(curr, count))
			}
		}
		return queue.peek()._1()
	}

}