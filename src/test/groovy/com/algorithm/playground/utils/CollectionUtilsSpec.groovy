package com.algorithm.playground.utils

import com.algorithm.playground.data.structure.Tuple2
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.utils.CollectionUtils.combinations
import static com.algorithm.playground.utils.CollectionUtils.permutation


class CollectionUtilsSpec extends Specification {

	private static final Random RND = new Random()

	@Unroll
	def "permutation"() {

		given:

			def l = (0..n).collect { RND.nextInt(20) }

		expect:

			l.permutations() == permutation(l) as Set

		where:

			n << [2, 3, 5, 7]

	}

	@Unroll
	def "combinations"() {

		given:

			def step = 2
			def curr = 1
			def list = (0..n).collect {
				curr = RND.nextInt(step) + curr + 1
				return curr
			}

			def expected = [list, list].combinations()
					.findAll { int l, int r -> l < r }
					.collect { int l, int r -> new Tuple2<>(l, r) }.toSet()

		expect:

			//noinspection GroovyAssignabilityCheck
			expected == combinations(list).toSet()

		where:

			n << [2, 3, 5, 7]

	}

}