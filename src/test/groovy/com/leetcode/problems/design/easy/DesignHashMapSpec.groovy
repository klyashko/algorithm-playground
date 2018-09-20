package com.leetcode.problems.design.easy

import com.leetcode.problems.design.easy.DesignHashMap.MyHashMap as HM
import spock.lang.Specification
import spock.lang.Unroll

class DesignHashMapSpec extends Specification {

	@Unroll
	def "myHashMap"() {

		given:

			def hm = new HM()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert hm."$method"(arg) == result
			}

		where:

			methods                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               | args || results
			["put", "put", "get", "get", "put", "get", "remove", "get"]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | [[1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]] || [null, null, 1, -1, null, 1, null, -1]
			["put", "put", "put", "put", "remove", "put", "put", "remove", "remove", "remove", "put", "put", "put", "put", "remove", "put", "put", "put", "put", "remove", "put", "put", "get", "put", "put", "put", "remove", "put", "put", "put", "put", "put", "put", "put", "get", "put", "remove", "remove", "put", "put", "put", "get", "put", "remove", "put", "remove", "get", "put", "put", "remove", "get", "put", "remove", "put", "put", "put", "put", "put", "put", "put", "get", "remove", "put", "put", "put", "put", "remove", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "get", "put", "remove", "put", "put", "remove", "remove"] | [[22, 83], [39, 4], [34, 88], [72, 99], [33], [58, 77], [23, 61], [34], [66], [90], [72, 83], [50, 98], [93, 97], [74, 95], [81], [56, 1], [86, 80], [93, 91], [13, 1], [93], [63, 11], [62, 63], [63], [71, 98], [97, 96], [65, 47], [93], [30, 78], [31, 40], [67, 86], [84, 11], [3, 19], [30, 97], [3, 36], [63], [92, 43], [71], [86], [77, 91], [18, 29], [75, 44], [59], [35, 81], [58], [12, 69], [58], [86], [84, 9], [83, 40], [82], [82], [55, 0], [65], [88, 83], [61, 83], [18, 68], [61, 19], [92, 74], [68, 15], [7, 99], [97], [92], [17, 96], [73, 22], [7, 16], [7, 16], [3], [0, 16], [22, 27], [74, 26], [63, 28], [84, 70], [44, 23], [51, 38], [65, 67], [75, 85], [50, 57], [75, 55], [4, 84], [9, 16], [69, 39], [40, 34], [99, 55], [74], [42, 53], [17, 9], [70, 92], [89, 11], [15, 64], [75, 22], [27, 59], [14, 84], [9], [40], [59, 47], [60], [33, 32], [63, 28], [15], [33]] || [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 11, null, null, null, null, null, null, null, null, null, null, null, 11, null, null, null, null, null, null, -1, null, null, null, null, -1, null, null, null, -1, null, null, null, null, null, null, null, null, null, 96, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 26, null, null, null, null, null, null, null, null, null, 34, null, null, null, null, null, null]
	}

}
