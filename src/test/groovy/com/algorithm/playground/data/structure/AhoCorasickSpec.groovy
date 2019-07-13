package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.*
import static java.lang.Math.min

class AhoCorasickSpec extends Specification {

	@Repeat(10)
	def "AhoCorasick#findAll(String)"() {

		given:

			def dict = nextList(nextInt(2, 10), { nextString(nextInt(2, 5)) })
			def text = nextString(nextInt(25, 50))
			int idx = 0, step = text.length() / 5

			while (idx < text.length()) {
				idx = nextInt(idx, min(idx + step, text.length()))
				def p = nextElement(dict)
				text = text.take(idx) + p + text.drop(idx)
				idx += p.length() + 1
			}

			def result = dict.collectMany { p -> findAll(text, p).collect { new Tuple2<>(p, it) } }
					.sort({ a, b -> a._2() <=> b._2() ?: a._1() <=> b._1() })

			def ac = new AhoCorasick(dict)

		expect:

			result == ac.findAll(text)

	}

}