package com.algorithm.playground.sort

import com.algorithm.playground.Repeat
import spock.lang.Specification

class SortUtilsSpec extends Specification {

	private static final Random RND = new Random()

	@Repeat(100)
	def "mergeSort"() {

		given:

			def arr = nextRandomArray(50, 100)
			def list = arr.toList()

		when:

			SortUtils.mergeSort(arr)

		then:

			arr == list.sort(false) as int[]

	}

	@Repeat(100)
	def "quickSort"() {

		given:

			def arr = nextRandomArray(100, 500)
			def list = arr.toList()

		when:

			SortUtils.quickSort(arr)

		then:

			arr == list.sort(false) as int[]

	}

	@Repeat(100)
	def "min"() {

		given:

			def arr = nextRandomArray(100, 500)
			def k = RND.nextInt(arr.length)

		when:

			def mins = SortUtils.min(arr, k)

		then:

			mins == arr.toList().sort()[0..k - 1] as int[]


	}

	private static int[] nextRandomArray(int size, int bound) {
		return (0..size - 1).collect { RND.nextInt(bound) } as int[]
	}

}
