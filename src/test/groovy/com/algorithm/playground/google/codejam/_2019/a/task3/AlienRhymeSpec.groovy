package com.algorithm.playground.google.codejam._2019.a.task3

import spock.lang.Specification
import spock.lang.Unroll

class AlienRhymeSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(words as String[]) == out

		where:

			words           || out
			['TARPOL',
			 'PROL']        || 2
			['TARPOR',
			 'PROL',
			 'TARPRO']      || 0
			['CODEJAM',
			 'JAM',
			 'HAM',
			 'NALAM',
			 'HUM',
			 'NOLOM']       || 6
			['PI',
			 'HI',
			 'WI',
			 'FI']          || 2
			['EDBEFEACA',
			 'BADAFACEEAED',
			 'C',
			 'EADBACDCFFDBBCFAA',
			 'CCBBDECAFDF'] || 2

	}

//	def "test"() {
//
//		given:
//
////			for (int i = 0; i < 1000000; i++) {
//			for (int i = 0; i < 100; i++) {
//				def words = []
//				1000.times {
//					words << randomUUID().toString()
//							.replaceAll("[0-9]", "")
//							.replaceAll("-", "")
//							.toUpperCase()
//				}
//
//				def right = Solution_.solve(words as String[])
//				def mine = Solution.solve(words as String[])
//
//				if (right != mine) {
//					println(right)
//					println(mine)
//					words.each { println(it) }
//					break
//				}
//
//				if (i % 100 == 0) {
//					println "Iteration ${i}"
//				}
//			}
//
//	}

}
