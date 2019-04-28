package com.algorithm.playground.sort

import com.algorithm.playground.utils.Repeat
import spock.lang.Specification

class SortUtilsSpec extends Specification {

	@Repeat(10)
	def "mergeSort"() {

		given:

			def rnd = new Random()
			def list = []
			50.times { list << rnd.nextInt(100) }
			def arr = list as int[]

		when:

			SortUtils.mergeSort(arr)

		then:

			arr == list.sort(false) as int[]

	}

}
