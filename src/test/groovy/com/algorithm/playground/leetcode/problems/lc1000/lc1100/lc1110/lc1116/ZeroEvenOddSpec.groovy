package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1110.lc1116

import spock.lang.Specification

import static java.util.concurrent.CompletableFuture.allOf
import static java.util.concurrent.CompletableFuture.runAsync

class ZeroEvenOddSpec extends Specification {

	def "runner"() {

		given:

			def zeo = new ZeroEvenOdd(5)
			allOf(
					runAsync({ zeo.zero({ i -> print(i) }) }),
					runAsync({ zeo.even({ i -> print(i) }) }),
					runAsync({ zeo.odd({ i -> print(i) }) })
			).join()

	}

}