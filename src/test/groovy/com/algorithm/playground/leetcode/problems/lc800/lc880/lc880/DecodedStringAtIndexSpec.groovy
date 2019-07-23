package com.algorithm.playground.leetcode.problems.lc800.lc880.lc880

import com.algorithm.playground.leetcode.problems.lc800.lc880.lc880.DecodedStringAtIndex.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 *
 *
 * Example 2:
 *
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 *
 *
 * Example 3:
 *
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 */
class DecodedStringAtIndexSpec extends Specification {

	@Unroll
	def "decodeAtIndex"() {

		expect:

			new S().decodeAtIndex(s, k) == out

		where:

			s                         | k         || out
			"leet2code3"              | 10        || "o"
			"ha22"                    | 5         || "h"
			"a2345678999999999999999" | 1         || "a"
			"y959q969u3hb22odq595"    | 222280369 || "y"
			"a2b3c4d5e6f7g8h9"        | 3         || "b"
			"a2b3c4d5e6f7g8h9"        | 10        || "c"
			"gl2sld3935dz5wx5r64x"    | 1392818   || "l"
			"abc"                     | 1         || "a"

	}

}