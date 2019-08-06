package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1110.lc1115

import spock.lang.Specification

import static java.util.concurrent.CompletableFuture.allOf
import static java.util.concurrent.CompletableFuture.runAsync

class FooBarSpec extends Specification {

	def "runner"() {

		given:

			def fb = new FooBar(2)
			allOf(
					runAsync({ fb.foo({ print("foo") }) }),
					runAsync({ fb.bar({ print("bar") }) })
			).join()

	}

}