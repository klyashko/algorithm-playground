package com.algorithm.playground.google.codejam._2019.round1.c.task3

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.round1.c.task3.Solution.main
import static com.algorithm.playground.google.utils.GoogleUtils.exec

class BacterialTacticsSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			output == expected

		where:

			[output, expected] << exec(
					{ main() },
					["""2 2
						..
						.#""", "0"],
					["""4 4
						.#..
						..#.
						#...
						...#""", "0"],
					["""3 4
						#.##
						....
						#.##""", "7"],
					["""3 4
						....
						....
						....""", "12"],
					["""3 3
						...
						...
						...""", "6"],
					["""1 1
						.""", "2"],
					["""1 2
						##""", "0"]
			)

	}

}
