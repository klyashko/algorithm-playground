package com.leetcode.problems.string.hard

import com.leetcode.problems.string.hard.InterleavingString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class InterleavingStringSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isInterleave"() {

		expect:

			new S().isInterleave(s1, s2, s3) == output

		where:

			s1      || s2      || s3           || output
			"aabcc" || "dbbca" || "aadbbcbcac" || true
			"aabcc" || "dbbca" || "aadbbbaccc" || false

	}

}
