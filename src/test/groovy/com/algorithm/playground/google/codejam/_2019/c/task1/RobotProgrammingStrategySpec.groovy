package com.algorithm.playground.google.codejam._2019.c.task1

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.google.codejam._2019.c.task1.Solution.main
import static com.algorithm.playground.google.utils.LocalTestRunner.exec
import static java.lang.Math.max

class RobotProgrammingStrategySpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			valid

		where:

			[valid] << isValid(
					{ main() },
					"""1
                       RS""",
					"""2
                       RP
                       SR""",
					"""3
                       RR
                       SS
                       RS""",
					"""3
                       RR
                       RS
                       RP""",
					"""3
                       R
                       P
                       S""",
					"""7
                       RS
                       RS
                       RS
                       RS
                       RS
                       RS
                       RS"""
			)

	}

	private static isValid(Runnable runner, String... inputs) {
		def outputs = exec(runner, inputs.toList()).collect {
			it[it.indexOf(':') + 2..it.length() - 1]
		}
		def programs = inputs.collect {
			it.split('\n').toList()[1..-1].collect { it.trim() }
		}
		return [programs, outputs].transpose().collect {
			//noinspection GroovyAssignabilityCheck
			[it[1] == 'IMPOSSIBLE' ? validateImpossible(it[0]) : validateProgram(it[1], it[0])]
		}
	}

	private static validateImpossible(List<String> programs) {
		def max = programs.max { it.length() }.length()
		return !(0..max).find { int idx -> programs.collect { it.charAt(idx % it.length()) }.toSet().size() == 3 }
	}

	private static validateProgram(String program, List<String> programs) {
		return !programs.find { isWinner(it, program) }
	}

	private static isWinner(String s1, String s2) {
		def max = max(s1.length(), s2.length()) + 1
		for (int i = 0; i < max; i++) {
			String ch1 = s1.charAt(i % s1.length()).toString()
			String ch2 = s2.charAt(i % s2.length()).toString()
			if (ch1 != ch2) {
				if (ch1 == 'P') {
					return ch2 == 'R'
				} else if (ch1 == 'R') {
					return ch2 == 'S'
				} else {
					return ch2 == 'P'
				}
			}
		}
		return false
	}

}