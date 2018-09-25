package com.leetcode.problems.heap.medium

import com.leetcode.problems.heap.medium.TopKFrequentWords.PriorityQueueSolution as PQS
import com.leetcode.problems.heap.medium.TopKFrequentWords.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class TopKFrequentWordsSpec extends Specification {

	@Unroll
	def "topKFrequent"() {

		expect:

			new S().topKFrequent(words as String[], k) == output

		where:

			words                                                                   | k || output
			["i", "love", "leetcode", "i", "love", "coding"]                        | 2 || ["i", "love"]
			["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"] | 4 || ["the", "is", "sunny", "day"]
			["i", "love", "leetcode", "i", "love", "coding"]                        | 1 || ["i"]

	}

	@Unroll
	def "topKFrequent_priority_queue"() {

		expect:

			new PQS().topKFrequent(words as String[], k) == output

		where:

			words                                                                   | k || output
			["i", "love", "leetcode", "i", "love", "coding"]                        | 2 || ["i", "love"]
			["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"] | 4 || ["the", "is", "sunny", "day"]
			["i", "love", "leetcode", "i", "love", "coding"]                        | 1 || ["i"]

	}

}
