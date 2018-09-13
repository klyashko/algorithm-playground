package com.leetcode.problems.twopointers.medium

import com.leetcode.problems.twopointers.medium.PartitionLabels.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PartitionLabelsSpec extends Specification {

	@Unroll
	def "partitionLabels"() {

		expect:

			new S().partitionLabels(input) == output

		where:

			input                      || output
			"ababcbacadefegdehijhklij" || [9, 7, 8]
			"caedbdedda"               || [1, 9]
			"eaaaabaaec"               || [9, 1]

	}

}
