package com.algorithm.playground.google.codejam._2019.round2.task2


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round2.task2.Solution.main
import static com.algorithm.playground.google.utils.LocalInteractiveTestRunner.run

class PotteryLotterySpec extends Specification {

	@Unroll
	def "Pottery Lottery"() {

		given:

			run({ main() }, "src/test/resources/google/codejam/_2019/PotteryLottery/", arg)

		where:

			arg || _
			"0" || _

	}

}