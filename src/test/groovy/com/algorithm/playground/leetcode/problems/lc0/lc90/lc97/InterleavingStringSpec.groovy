package com.algorithm.playground.leetcode.problems.lc0.lc90.lc97

import com.algorithm.playground.leetcode.problems.lc0.lc90.lc97.InterleavingString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class InterleavingStringSpec extends Specification {

	@Unroll
	def "isInterleave"() {

		expect:

			new S().isInterleave(s1, s2, s3) == output

		where:

			s1                                                                                                     || s2      || s3                                                                                            || output
			"aabcc"                                                                                                || "dbbca" || "aadbbcbcac"                                                                                  || true
			"aabcc"                                                                                                || "dbbca" || "aadbbbaccc"                                                                                  || false
			"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa" ||
					"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab"    ||
					"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab" || false

	}

}
