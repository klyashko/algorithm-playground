package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextString

class SuffixTreeSpec extends Specification {

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

}