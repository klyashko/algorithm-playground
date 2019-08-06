package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1114

import spock.lang.Specification

import static java.util.concurrent.CompletableFuture.allOf
import static java.util.concurrent.CompletableFuture.runAsync

class FooSpec extends Specification {

	def "runner"() {

		given:

			def foo = new Foo()

			allOf(
					runAsync({ foo.first({ print("first") }) }),
					runAsync({ foo.second({ print("second") }) }),
					runAsync({ foo.third({ print("third") }) })
			).join()

	}

}